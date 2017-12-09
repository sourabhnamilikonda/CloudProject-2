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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseInformation 
{
public  ArrayList<DatabasePojo> fetchData()
    {
         ArrayList<DatabasePojo> pojo=null;
        
    try {
        System.out.println("check1");
       
        Connection connectionObject=null;
        PreparedStatement statementObject=null;
        ResultSet resultSetObject=null;
        
       pojo=new ArrayList<DatabasePojo>();
        DatabasePojo pojoObject;
        
        String query="select * from medicine_reminder";
        
        Connection1 databaseObject=new Connection1();
        connectionObject = databaseObject.mk_conn();
        
        System.out.println("check2");
        
        if(connectionObject!=null)
        {
            System.out.println("check3");
            try
            {
                System.out.println("check4");
                statementObject=connectionObject.prepareStatement(query);
                statementObject = connectionObject.prepareStatement(query);
                
                
                
                resultSetObject = statementObject.executeQuery(); 
                System.out.println("check5");
                while(resultSetObject.next())
                {
                    System.out.println("check6");
                    pojoObject=new DatabasePojo();
                    String medicine_name=resultSetObject.getString("medicine_name");
                    String frequency=resultSetObject.getString("frequency");
                    String week=resultSetObject.getString("week");
                    String time=resultSetObject.getString("time");
                    String creation_date=resultSetObject.getString("creation_date");
                    
                    
                    
                    pojoObject.setMedicine_name(medicine_name);
                    
                    
                    pojoObject.setFrequency(frequency);
                    pojoObject.setWeek(week);
                    pojoObject.setTime(time);
                    pojoObject.setDate_of_creation(creation_date);
                    
                    
                    pojo.add(pojoObject);  
                    System.out.println("check7");
                }
            }
            catch (SQLException ex) 
            {
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
                    
                    System.out.println("check8");
                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                
            }
        
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(DatabaseInformation.class.getName()).log(Level.SEVERE, null, ex);
    }
   return pojo;

    }
    
}
