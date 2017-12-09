/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediworld;

import com.mycompany.poly.SpeechRecognition;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteScheduleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         String medicine=request.getParameter("name");
         DeleteSchedule schedule=new DeleteSchedule();
        try {
            schedule.deletemedicineInformation(medicine);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteScheduleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         String ViewSchedule="ViewMyRemainders.jsp";
         
         SpeechRecognition speech=new SpeechRecognition();
         speech.reminderDelete();
         
          RequestDispatcher dispatcher = request.getRequestDispatcher(ViewSchedule);
          dispatcher.forward(request, response);
        
        
    }

   

}
