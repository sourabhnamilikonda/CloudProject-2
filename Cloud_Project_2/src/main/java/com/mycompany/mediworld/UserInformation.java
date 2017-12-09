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


public class UserInformation 
{
public String getPhoneNo(String userName) throws SQLException
       
{
    String serverId=null;
    
     PreparedStatement statementObject=null;
     ResultSet resultSetObject=null;
      Connection conn=null;
        
     System.out.println("userName name in db file is:"+userName);
     
        String query="select * from user where username = ?";
        
    
    Connection1 connection=new Connection1();
    conn = connection.mk_conn();
    
    if(conn!=null)
    {
         try 
           {
               
               
                statementObject = conn.prepareStatement(query);
                statementObject.setString(1, userName); 
                System.out.println("Query is:"+query);
                resultSetObject = statementObject.executeQuery();
                
                if(resultSetObject.next())
                {
                   serverId=resultSetObject.getString("phone");
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
                          if(conn!=null)
                              connection.close_conn(conn);
                          
                } catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
                
            }
        
    }
    
    return serverId;
 }

public String getEmail(String userName) throws SQLException
       
{
    String serverId=null;
    
     PreparedStatement statementObject=null;
     ResultSet resultSetObject=null;
      Connection conn=null;
        
     System.out.println("userName name in db file is:"+userName);
     
        String query="select email from user where username = ?";
        
    
    Connection1 connection=new Connection1();
    conn = connection.mk_conn();
    
    if(conn!=null)
    {
         try 
           {
               
               
                statementObject = conn.prepareStatement(query);
                statementObject.setString(1, userName); 
                System.out.println("Query is:"+query);
                resultSetObject = statementObject.executeQuery();
                
                if(resultSetObject.next())
                {
                   serverId=resultSetObject.getString("email");
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
                          if(conn!=null)
                              connection.close_conn(conn);
                          
                } catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
                
            }
        
    }
    
    return serverId;
 }


public String getMedicine(String userName) throws SQLException
       
{
    String serverId=null;
    
     PreparedStatement statementObject=null;
     ResultSet resultSetObject=null;
      Connection conn=null;
        
     System.out.println("userName name in db file is:"+userName);
     
        String query="select * from user where username = ?";
        
    
    Connection1 connection=new Connection1();
    conn = connection.mk_conn();
    
    if(conn!=null)
    {
         try 
           {
               
               
                statementObject = conn.prepareStatement(query);
                statementObject.setString(1, userName); 
                System.out.println("Query is:"+query);
                resultSetObject = statementObject.executeQuery();
                
                if(resultSetObject.next())
                {
                   serverId=resultSetObject.getString("medicines");
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
                          if(conn!=null)
                              connection.close_conn(conn);
                          
                } catch (SQLException ex) 
                {
                    ex.printStackTrace();
                }
                
            }
        
    }
    
    return serverId;
 }



}
