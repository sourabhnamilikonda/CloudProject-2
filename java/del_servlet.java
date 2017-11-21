import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Avleen Singh Khanuja
 */
@WebServlet(urlPatterns = {"/del_servlet"})
public class del_servlet extends HttpServlet 
{
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) 
            {
                String username = request.getSession(false).getAttribute("ulog").toString();
                String bucketName = "cmpe281project1";
                String SUFFIX = "/";
                String filename = request.getParameter("delobj");
                String key;
                key = username + SUFFIX + filename;
                
                AWSCredentials credentials = new BasicAWSCredentials("Access Key","Access Key Secret");
				AmazonS3 s3client = new AmazonS3Client(credentials);
                s3client.setRegion(Region.getRegion(Regions.US_WEST_1));
                s3client.setEndpoint("s3-us-west-1.amazonaws.com");
                
                s3client.deleteObject(bucketName, key);
                
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://RDS Host Name:Port Number/Database Name","Master_Username","Password"");
               Statement st= con.createStatement();
               st.executeUpdate("Delete from file_info where f_name='"+filename+"'");
               response.sendRedirect("listOfFiles.jsp");
               }
      catch(Exception e)
      {
          
      }
      
    }
}