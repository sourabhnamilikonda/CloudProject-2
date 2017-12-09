/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.poly.SpeechRecognition;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String index="index.jsp";
        String userName1=request.getParameter("hidden1");
        String userName2=request.getParameter("hidden2");
        String userName=null;
        if(userName1==null)
        {
            userName=userName2;
        }
        else
        {
            userName=userName1;
        }
            
        SpeechRecognition speech=new SpeechRecognition();
        speech.logOutUser(userName);
        RequestDispatcher rd=request.getRequestDispatcher(index);
        rd.forward(request, response);
    }

  

}
