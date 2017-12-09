/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediworld;

import com.mycompany.poly.SpeechRecognition;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetReminderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       String medicine=request.getParameter("medicine");
       String time=request.getParameter("usr_time");
       String frequency=request.getParameter("Frequecy");
       String week=request.getParameter("week");
       
       String schedule="ScheduleAppointment.jsp";
       String getHiddenValue=request.getParameter("hidden");
       
        System.out.println("Hidden value is:"+getHiddenValue);
       
        String[] s1=time.split(":");
        int hours=Integer.parseInt(s1[0]);
        
        if(hours==0)
        {
            hours=hours+12;
            time=String.valueOf(hours)+":"+s1[1]+" am";
            System.out.println("Time is "+time);
        }
        else if(hours>12)
        {
            hours=hours-12;
            time=String.valueOf(hours)+":"+s1[1]+" pm";
            System.out.println("Time is "+time);
        }
        else if(hours==12)
        {
       
            time=String.valueOf(hours)+":"+s1[1]+" pm";
            System.out.println("Time is "+time); 
        }
        else if(hours<12)
        {
            time=String.valueOf(hours)+":"+s1[1]+" am";
             System.out.println("Time is "+time);
        }
        InsertReminder reminder=new InsertReminder();
        reminder.insertDataForInstance(medicine, frequency, week, time);
        
        MessagePasser passer=new MessagePasser();
        passer.sendMessage(getHiddenValue,medicine);
       
        SpeechRecognition speech=new SpeechRecognition();
        speech.reminderSet(getHiddenValue);
        
         RequestDispatcher rd=request.getRequestDispatcher(schedule);
        rd.forward(request, response);
       
    }


}
