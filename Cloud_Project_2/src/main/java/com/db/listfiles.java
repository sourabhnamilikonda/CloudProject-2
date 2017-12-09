package com.db;
import com.setget.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class listfiles 
{
    public  ArrayList<set> f_d(String username) throws SQLException
    {
        System.out.println("check1");
       
        Connection connObj=null;
        PreparedStatement stmtObj=null;
        ResultSet rsObj=null;
        
         ArrayList<set> s=new ArrayList<set>();
         set sObject;
         
        String query="select * from file_info,user where fk_id=(select id from user where username=?) AND id=(select id from user where username=?)";
        
        Connection1 dbObjt=new Connection1();
        connObj = dbObjt.mk_conn();
        
        System.out.println("check2");
        
        if(connObj!=null)
        {
            System.out.println("check3");
            try 
           {
               System.out.println("check4");
                stmtObj=connObj.prepareStatement(query);
                stmtObj = connObj.prepareStatement(query);
                stmtObj.setString(1, username);
                stmtObj.setString(2, username);
                
                
               rsObj = stmtObj.executeQuery();
               System.out.println("check5"); 
                while(rsObj.next())
                {
                     System.out.println("check6");
                    sObject=new set();
                    String file_name=rsObj.getString("f_name");
                    String file_upload_time=rsObj.getString("f_upload_time");
                    String file_description=rsObj.getString("file_desc");
                    String first_name=rsObj.getString("first_name");
                    String last_name=rsObj.getString("last_name");
                    String file_update_time=rsObj.getString("f_update_time");
                    
                    if(file_update_time==null)
                        file_update_time="not updated yet";
                    sObject.setFileName(file_name);
                    sObject.setFileDescription(file_description);
                    sObject.setFileUploadTime(file_upload_time);
                    sObject.setFirstName(first_name);
                    sObject.setLastName(last_name);
                    sObject.setUpdateTime(file_update_time);
                    s.add(sObject);  
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
                         if(rsObj!=null)
                             rsObj.close();
                          if(stmtObj!=null)
                              stmtObj.close();
                          if(connObj!=null)
                              dbObjt.close_conn(connObj);
                 
                          System.out.println("check8");
                } catch (SQLException ex) 
                {
                    Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        
        }
        return s;

    }
}
