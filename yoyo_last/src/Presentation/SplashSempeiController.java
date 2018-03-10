/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.awt.SplashScreen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class SplashSempeiController implements Initializable {
    @FXML
    private AnchorPane splashpane;
    @FXML
    private ImageView img2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new SplashScreen().start();
    }    
    
     class SplashScreen extends Thread
    {
        @Override
        public void run()
        {
            try {
                Thread.sleep(5000);
                
                  Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                     Parent root;
                try {
                     root = FXMLLoader.load(getClass().getResource("Acceil.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Patient home loader");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        
                  
                         splashpane.getScene().getWindow().hide();
                } catch (IOException ex) {
                   // Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error in loading Splash Sempei \n"+ex);
                }
                        
                                    }
                });
                
                
            } catch (InterruptedException ex) {
                //Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("error in loading Splash Sempei nterruptin de type  \n"+ex);
            }
        }
    }
}
