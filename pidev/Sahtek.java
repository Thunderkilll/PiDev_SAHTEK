/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtek;


import DB.MyConnection;
import Entite.Maladie;
import Iservices.Imaladies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.MyConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import services.ServicesMaladie;
import static sun.security.jgss.GSSUtil.login;


/**
 *
 * @author music
 */
  
public class Sahtek extends Application {
 Connection con ;
    
 public Sahtek() 
    {
        con = MyConnection.getInstance().getCon() ;
    }



  
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root)   ;
      
        // Line
       
       
      
ServicesMaladie sc = new ServicesMaladie() ;
Maladie m1=new Maladie("hh","hh","hh") ;

sc.Ajouter_m(m1);
  
      
        stage.setScene(scene);
        stage.setTitle("Sahtek") ;
        
        stage.show();
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

  
  
 
    
}
