import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/search"})
public class search extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            String subject = request.getParameter("txtname1");
            URL url = new URL("https://en.wikipedia.org/w/index.php?action=raw&title=" + subject);
            String text = "";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
            String line = null;
            while (null != (line = br.readLine())) {
            line = line.trim();
            if (!line.startsWith("|")
                    && !line.startsWith("{")
                    && !line.startsWith("}")
                    && !line.startsWith("<center>")
                    && !line.startsWith("---")) 
            {
                    text=line;
        }
            
        if (text.length() > 200) {
            break;
        }
    }
}
        out.print(text);
            
            
        }
    }
}
