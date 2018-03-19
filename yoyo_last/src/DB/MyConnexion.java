/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khaled22
 */
public class MyConnexion {
    
    private String url="jdbc:mysql://localhost:3306/pidev";
    private String login="root";
    private String passwd="" ;
    private Connection conn ;
    private static MyConnexion instance = null ;
     
    private MyConnexion () {
        try {
            conn =  DriverManager.getConnection(url,login, passwd);
            
             System.out.println("connexionn done !");
             
        } catch (SQLException ex) {
            System.out.println("connexionn failed ??!!");
        }
        
    }
    
   public static MyConnexion Get_Instance () {
       if (instance == null){
           instance = new  MyConnexion();
       }
        return instance ;
       
       
   }
   public Connection getCon() {
       
       return conn ;
   }
    
}
