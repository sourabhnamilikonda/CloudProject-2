package com.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reg 
{
    public boolean register(String firstName,String lastName,String email,String password,String userName, String dob,String phone) throws SQLException
    {
        boolean flagReg=false ;
        Connection connObj=null;
        PreparedStatement stmtObj=null;
        ResultSet rsObj=null;
        
        String query="INSERT INTO user(first_name,last_name,email,passwd,username,date_of_birth,phone) VALUES (?,?,?,?,?,?,?)";
        
        Connection1 dbObjt=new Connection1();
        connObj = dbObjt.mk_conn();
        
        if(connObj!=null)
        {
            try 
           {
                stmtObj=connObj.prepareStatement(query);
                System.out.println("Query is:"+query);
                stmtObj = connObj.prepareStatement(query);
                stmtObj.setString(1, firstName);
                stmtObj.setString(2, lastName);
                stmtObj.setString(3, email);
                stmtObj.setString(4, password);
                stmtObj.setString(5, userName);
                stmtObj.setString(6, dob);
                stmtObj.setString(7, phone);
                
              flagReg= stmtObj.execute();
  
                
           } 
            catch (SQLException ex) 
            {
                System.out.println("Exception is:"+ex);
          }
            finally
            {
               
                    try 
                    {
                         if(rsObj!=null)
                             rsObj.close();
                          if(stmtObj!=null)
                              stmtObj.close();
                          if(connObj!=null)
                              dbObjt.close_conn(connObj);
                          
                } catch (SQLException ex) 
                {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        }
  
        return flagReg;
    }
}
