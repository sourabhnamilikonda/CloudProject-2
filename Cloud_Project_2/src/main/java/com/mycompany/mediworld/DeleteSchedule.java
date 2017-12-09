/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mediworld;

import com.db.Connection1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DeleteSchedule 
{
    
    public void deletemedicineInformation(String medicineName) throws SQLException
    {
       
        Connection connectionObject=null;
        PreparedStatement statementObject=null;
        ResultSet resultSetObject=null;
        
        String query="DELETE FROM medicine_reminder where medicine_name=?";
        
        Connection1 databaseObject=new Connection1();
        connectionObject = databaseObject.mk_conn();
        
        if(connectionObject!=null)
        {
            try 
           {
                statementObject=connectionObject.prepareStatement(query);
                
                statementObject = connectionObject.prepareStatement(query);
                statementObject.setString(1,medicineName);
                
                System.out.println("Query is:"+query);
               
                boolean flag = statementObject.execute();
                if(flag)
                {
                    System.err.println("Flag is true:"+flag);
                }
  
                
           } 
            catch (SQLException ex) 
            {
                System.out.println("Exception is:"+ex);
                ex.printStackTrace();
          }
            finally
            {
               
                    try 
                    {
                         if(resultSetObject!=null)
                             resultSetObject.close();
                          if(statementObject!=null)
                              statementObject.close();
                          if(connectionObject!=null)
                              databaseObject.close_conn(connectionObject);
                          
                } catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
                
            }
        
        }
    }
    
    
}
