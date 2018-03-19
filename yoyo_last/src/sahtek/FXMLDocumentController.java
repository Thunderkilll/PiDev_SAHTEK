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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import Services.Services_user ;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author music
 */
public class FXMLDocumentController implements Initializable  {
   
          
   

    @FXML
    private Pane rightContainer;
    @FXML
    private TextField userid;
    @FXML
    private PasswordField passwordid;
    @FXML
    private Button conn;
    @FXML
    private Label nouveau1;
    @FXML
    private Label status;
    @FXML
    private Pane rightContainer1;
    @FXML
    private Label nouveau;
    @FXML
    private Label user_role;
    @FXML
    private Button button_patient;
    @FXML
    private Button button_beaute;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Authentifier(ActionEvent event) throws InterruptedException, IOException {
        
        
       
         Services_user su=new Services_user() ;
         
         String test = su.check_user_confirmation(userid.getText()) ;
      
        
      if ( (su.authentifier(userid.getText(), passwordid.getText())) )
      {
           
          if ( su.check_user_confirmation(userid.getText())=="confirmed" )
          {
              
              
          System.out.println( test) ;
              
         //user_role.setText("Vous etes connecté en tant que '"+su.get_role(userid.getText())+"'");
      if (su.get_role(userid.getText())=="patient")
      {
          FXMLLoader loader = new FXMLLoader() ;
          Parent v_b= loader.load(getClass().getResource("interace_OffreClient.fxml").openStream())  ;
        Confirmation_boxController out = new Confirmation_boxController() ;
        out = loader.getController();
      
        Stage stage=  (Stage) ((Node)event.getSource()).getScene().getWindow() ;
  stage.setScene(new Scene(v_b));
        
         
         stage.showAndWait();
      }
      else if (su.get_role(userid.getText())=="medecin")
      {
          
      }
      else if (su.get_role(userid.getText())=="beaute")
      {
          user_role.setText("beaute");
      }
      else if (su.get_role(userid.getText())=="pharmacien")
      {
          user_role.setText("pharmacien");
      }
          }
          
      
   else if (  test=="not_confirmed")
      {
             System.out.println( test) ;
          FXMLLoader loader= new FXMLLoader() ;
          
        Parent v_b= loader.load(getClass().getResource("confirmation_box.fxml").openStream())  ;
        Confirmation_boxController out = new Confirmation_boxController() ;
        out = loader.getController();
        Stage stage=  (Stage) ((Node)event.getSource()).getScene().getWindow() ;
        out.SetData(userid.getText());
            
        stage.setScene(new Scene(v_b));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

          System.out.println("pas confirme");
           
      }
      }
      else
      {
          user_role.setText("compte non valid");
      }
      
        
    }

    @FXML
    private void z(MouseEvent event) {
    }

    @FXML
    private void Redirection_Patient(ActionEvent event) throws IOException {
         Parent Patient_parent = FXMLLoader.load(getClass().getResource("Patient_Inscription.fxml")) ;
            Scene patient_scene =new Scene(Patient_parent) ;
            Stage app_stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
            
            app_stage.setScene(patient_scene);
            app_stage.show();
        
     
        
    }
     @FXML
    private void Redirection_Beaute(ActionEvent event) throws IOException {
         Parent Patient_parent = FXMLLoader.load(getClass().getResource("Beaute_Inscription.fxml")) ;
            Scene patient_scene =new Scene(Patient_parent) ;
            Stage app_stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
            
            app_stage.setScene(patient_scene);
            app_stage.show();
        
     
        
    }
    
}
