package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connection1 
{
        public Connection mk_conn() throws SQLException
    {
       Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://","","");  
          
           
            if(con!=null)
                System.out.println("connection successful");
            else
                System.out.println("connection failure");          
            
         
        }
        catch(ClassNotFoundException | SQLException e  )
        {
            System.out.println("Issue is"+e);
        }
     return con;   
    }
    public void close_conn(Connection con)
    {
        if(con!=null)
        try 
            {
                con.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Connection1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
