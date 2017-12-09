import com.db.listfiles;
import com.setget.set;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/showinfo"})
public class showinfo extends HttpServlet 
{
    private ArrayList<set> s;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
        String username;
        String ls="listOfFiles.jsp";
        username = request.getSession(false).getAttribute("ulog").toString();
        listfiles show=new listfiles();
        s=show.f_d(username);
        request.setAttribute("DatabaseValues",s);
        RequestDispatcher dispatcher = request.getRequestDispatcher(ls);
        dispatcher.forward(request, response);
        
    }   catch (SQLException ex) {
            Logger.getLogger(showinfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }