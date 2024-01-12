/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryms;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lenovo
 */
    
public class DBConnection {
    Connection con=null;
    public static Connection getConnection() 
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
        return conn;

        }
        catch(Exception e)
        {
            e.printStackTrace();
           return null;
        }
    }
}
