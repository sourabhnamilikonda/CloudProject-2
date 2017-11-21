package com.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Avleen Singh Khanuja
 */
public class log
{
        public boolean login(String username,String password) throws SQLException
    {
        boolean flagLog=false ;
        Connection connObj=null;
        PreparedStatement stmtObj=null;
        ResultSet rsObj=null;
        
        String query="select * from user where username=? and passwd=?";
        
        Connection1 dbObjt=new Connection1();
        connObj = dbObjt.mk_conn();
        
        if(connObj!=null)
        {
            try 
           {
                stmtObj=connObj.prepareStatement(query);
                stmtObj = connObj.prepareStatement(query);
                stmtObj.setString(1, username);
                stmtObj.setString(2, password);
                rsObj = stmtObj.executeQuery();
                
                if(rsObj.next())
                    flagLog=true; 
                else
                    flagLog=false;
                
                
                
                
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
  
        return flagLog;
    }
}
