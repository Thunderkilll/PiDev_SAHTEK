/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtek;


import DB.MyConnexion;


import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;




/**
 *
 * @author music
 */
 
public class Sahtek extends Application {
 static Connection con ;
    
 public Sahtek() 
    {
        con = MyConnexion.Get_Instance().getCon() ;
    }



  
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Acceuil_Auth.fxml"));
        
        Scene scene = new Scene(root)   ;
     
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
