/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtek;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import Entite.Patient; 
import Services.Services_Patient ;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author parasol
 */
public class Confirmation_boxController implements Initializable {
    @FXML
    private TextField code_id;
    @FXML
    private Pane paneCode;
    @FXML
    private Button bouttonConfirm;
    private Label show_user;
    @FXML
    private TextField getUsername;
    @FXML
    private TextField Code_Status;

    /**
     * Initializes the controller class.
     */
    
    public void SetData(String username)
    {
        getUsername.setText(username);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    private void confirmer_compte(ActionEvent event) {
        Services_Patient sp=new Services_Patient() ;
      
        
       
    }

    @FXML
    private void test(ActionEvent event) throws IOException, InterruptedException {
        Parent root2=FXMLLoader.load(getClass().getResource("Acceuil_Auth.fxml")) ;
        
        Scene scene=new Scene(root2) ;
        Stage back=new Stage() ;
                
        Services_Patient sp=new Services_Patient() ;
       int id=sp.Id_user(getUsername.getText());
        System.out.println(id);
       
      if (sp.validation(id,Integer.parseInt(code_id.getText())))
      {
          Code_Status.setText("Code correct");
          back.setScene(scene);
          Thread.sleep(5000) ;
          back.show();
          
          
      }
      else
      {
          Code_Status.setText("Compte non correct");
          
          
      }
      
        
        
    
    }
    
}
