package com.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File_info 
{
     public void addDataToDb(String userName,ArrayList<String> arrayListOfFile) throws SQLException
    {
        
        boolean flagLog=false ;
        Connection connObj=null;
        PreparedStatement stmtObj=null;
        ResultSet rsObj=null;
        int pk_id;
        
        String query;
        query = "INSERT INTO file_info(fk_id,f_name,f_upload_time,file_desc) VALUES ( (SELECT id from user WHERE username=?),?,?,?)";
        
        Connection1 dbObjt=new Connection1();
        connObj = dbObjt.mk_conn();
        
         DateFormat dt_format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
         String dateStr=dt_format.format(date);
      
        
        if(connObj!=null)
        {
            try 
           {
                stmtObj=connObj.prepareStatement(query);
                System.out.println("Query is:"+query);
                stmtObj = connObj.prepareStatement(query);
           
                
               for(int i=0;i<arrayListOfFile.size();i++)
               {
                    stmtObj.setString(1, userName);
                    String filename=arrayListOfFile.get(i).toString();
                    String fileDescription=filename.substring(filename.lastIndexOf(".") + 1);
                    stmtObj.setString(2,filename );
                    stmtObj.setString(3,dateStr );
                    stmtObj.setString(4, fileDescription);
                    stmtObj.execute();
               }
               
                System.out.println("Database updated with file info:::::::");
               
                
                
                
                
                
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
  
//        return flagLog;
        
        
    }
}
