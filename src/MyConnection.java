/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

// Connexion la BDDD bibliothéque
public class MyConnection {
    
    
    public static Connection getConnection(){
        
        Connection conn = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            
            //On Charge le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bibliothéque", "root", "");
            
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
}
