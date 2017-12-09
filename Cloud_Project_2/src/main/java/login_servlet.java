import com.db.log;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/login_servlet"})
public class login_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String username=null;
        String password=null;
        boolean flag=false;
        String mainMenuPage="user_acc.jsp";
        String loginPage="login.jsp";
        String message="invalid username/password";
       
       username= request.getParameter("txtname1").toString();

       password=request.getParameter("txtpass").toString();
         
       log loginObject=new log();
       flag = loginObject.login(username, password);
       
       if(flag)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("ulog", username);
          try 
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher(mainMenuPage);
            dispatcher.forward(request, response);
           
           
        } 
        catch (ServletException | IOException ex) 
        {
            Logger.getLogger(login_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       else
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("ulog", "invalid");
            System.out.println("unsuccessful login::::");
         
          RequestDispatcher dispatcher2 = request.getRequestDispatcher(loginPage);
          request.setAttribute("invalid username/password",message);
          
            try {
                dispatcher2.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(login_servlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(login_servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }   
    }   catch (SQLException ex) {
            Logger.getLogger(login_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

