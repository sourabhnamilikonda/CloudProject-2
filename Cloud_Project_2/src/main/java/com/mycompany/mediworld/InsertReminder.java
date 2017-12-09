/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediworld;

import com.db.Connection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class InsertReminder 
{
 public void insertDataForInstance(String medicine_name,String frequency,String week,String time)
   {
       Connection connectionObject=null;
       PreparedStatement statementObject=null;
       Connection1 databaseConnection=null;
        
       
       try
       {
          databaseConnection=new Connection1();
          connectionObject = databaseConnection.mk_conn();
             DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
         java.util.Date date = new java.util.Date();
         String dateString=dateFormat.format(date);
           System.out.println("date:"+dateString);
          
           String queryOfInsert="INSERT INTO medicine_reminder(medicine_name,frequency,week,time,creation_date) VALUES (?,?,?,?,?)";
                 
                    statementObject = connectionObject.prepareStatement(queryOfInsert);                     
                    statementObject.setString(1, medicine_name);
                    statementObject.setString(2,frequency);
                    statementObject.setString(3,week);
                    statementObject.setString(4,time);
                    statementObject.setString(5,dateString);
                  
                    statementObject.execute();
           
          
          
         
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       finally
       {
          
               try 
               {
                    if(statementObject!=null)
                   statementObject.close();
                    
                    if(connectionObject!=null)
                        databaseConnection.close_conn(connectionObject);
                    
           } catch (SQLException ex) 
           {
              ex.printStackTrace();
           }
       }
   }   
}
