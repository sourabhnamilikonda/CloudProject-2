import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.db.File_info;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;


@WebServlet(urlPatterns = {"/update_serv"})
public class update_serv extends HttpServlet 
{
   private static final String SUFFIX = "/";   
   private static boolean flag=true;
   String bucketName = "";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
       ArrayList<String> arrayListOfFile;
        arrayListOfFile = new ArrayList<>();
        
      String usr= request.getSession(false).getAttribute("ulog").toString();
      
      AWSCredentials credentials = new BasicAWSCredentials("", "");
           
            AmazonS3 s3client = new AmazonS3Client(credentials);
            s3client.setRegion(Region.getRegion(Regions.US_WEST_1));
            s3client.setEndpoint("s3-us-west-1.amazonaws.com");
            
            List<Part> f_parts;
            
            f_parts = request.getParts().stream().filter(part -> "objUpdate".equals(part.getName())).collect(Collectors.toList());
            
            ObjectListing folderList;
        folderList = s3client.listObjects(bucketName);

      
       List<S3ObjectSummary> summary = folderList.getObjectSummaries();
       folderList = s3client.listNextBatchOfObjects (folderList);
       summary.addAll (folderList.getObjectSummaries());
       
        for (S3ObjectSummary objSumm : summary) 
       {
	    String uniqueId = objSumm.getKey();
            if(uniqueId.equals(usr))
            {   
                flag=false;
                break;
                
            }
            else
            {
                System.out.println("check2");
                flag=true;
            }
       }  
        
        if(flag)
        createFolder(bucketName, usr, s3client);
       
          for(Part filePart : f_parts) 
         { 
          String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
         
          InputStream fileContent = filePart.getInputStream();
                
          StringWriter writer = new StringWriter();
          IOUtils.copy(fileContent,writer,"UTF-8");
          String theFileContent= writer.toString();
        
          File file = new File(fileName);         
          file.createNewFile();

          FileWriter fwriter = new FileWriter(file);
          fwriter.write(theFileContent);
          fwriter.close();
          
          String completeFilePath = usr + SUFFIX + fileName;
          
          s3client.putObject(new PutObjectRequest(bucketName,completeFilePath,file));
          
          arrayListOfFile.add(fileName);
          
        } 
        
        File_info info=new File_info();
       try {
           info.addDataToDb(usr,arrayListOfFile);
       } catch (SQLException ex) {
           Logger.getLogger(index_serv.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        response.sendRedirect("user_acc.jsp");
   
    }  
    
    public static void createFolder(String bucketName, String folderName, AmazonS3 client) {

	ObjectMetadata metadata = new ObjectMetadata();
	metadata.setContentLength(0);
	
	InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
	
	PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + SUFFIX, emptyContent, metadata);
	
	client.putObject(putObjectRequest);
}
    }
