package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avleen Singh Khanuja
 */
public class Connection1 
{
        public Connection mk_conn() throws SQLException
    {
       Connection con=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://RDS Host Name:Port Number/Database Name","Master_Username","Password");  
        }
        catch(ClassNotFoundException | SQLException e  )
        {
            System.out.println("Error: "+e);
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
