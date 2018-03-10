/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtek;

import Services.Services_Patient;
import Services.Services_user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class Acceuil_AuthController implements Initializable {
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
    private Label user_role;
    @FXML
    private Pane rightContainer1;
    @FXML
    private Label nouveau;
    @FXML
    private Button button_patient;
    @FXML
    private Button button_beaute;
    
  //  Services.Services_Patient sp = new Services_Patient();
    
    Services_user su = new Services_user();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Authentifier(ActionEvent event) {
//        String passwd = passwordid.getText();
//        String username = userid.getText();
//        if(su.authentifier(username ,passwd)){
//            
              try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("../Presentation/SplashSempei.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) conn.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }
        
        
    

    @FXML
    private void z(MouseEvent event) {
    }

    @FXML
    private void Redirection_Patient(ActionEvent event) {
    }

    @FXML
    private void Redirection_Beaute(ActionEvent event) {
    }
    
}
