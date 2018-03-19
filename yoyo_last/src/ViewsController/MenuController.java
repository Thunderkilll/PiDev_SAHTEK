/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewsController;

import Entite.Patient;
import Entite.Users;
import Presentation.AcceilController;
import static Presentation.AcceilController.rootS;
import Presentation.ProfileController;
import Services.Services_Patient;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**  
 * FXML Controller class
 *
 * @author samie
 */
public class MenuController implements Initializable {
    @FXML
    private JFXButton profileBTN;
    @FXML
    private JFXButton messageBTN;
    @FXML
    private JFXButton exitBTN;
    @FXML
    private JFXButton butFiche;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cliquer(ActionEvent event) {
        try {
              FXMLLoader fxmlLader = new FXMLLoader();
              fxmlLader.setLocation(getClass().getResource("/Presentation/Profile.fxml"));
        AnchorPane pane =  FXMLLoader.load(getClass().getResource("/Presentation/Profile.fxml"));
        Parent p3 = fxmlLader.load();
        Scene s3 = new Scene(p3);
        Services_Patient cp = new Services_Patient();
        Patient uc = cp.recherchePatient(1);
        ProfileController  c =  (ProfileController) fxmlLader.getController() ;
        c.getLblnom().setText(uc.getNom());
        c.getLblprenom().setText(uc.getPrenom());
        c.getLblemail().setText(uc.getEmail());
        c.getLblcin().setText(String.valueOf(uc.getCin()));
        c.getLbladresse().setText(uc.getAdresse());
        c.getbltelephone().setText(String.valueOf(uc.getTelephone()));
        c.getLbUsername().setText(uc.getUsername());
        c.getDateNaissance().setText(String.valueOf(uc.getDateNaissance()));
        File file = new File(Services_Patient.ImageConverter(uc.getImage()));
        Image image = new Image(file.toURI().toString());
        c.getImgProf().setImage(image);
        Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
           AcceilController.rootS.getChildren().clear();
            AcceilController.rootS.getChildren().add(pane);
        
        } catch (IOException ex) {
            System.out.println("exceptin in menu"+"\n"+ex);
             Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
    }

    @FXML
    private void message(ActionEvent event) {
             
        try {
            AnchorPane pane  = FXMLLoader.load(getClass().getResource("/Presentation/Articles.fxml"));
            AcceilController.rootS.getChildren().clear();
            AcceilController.rootS.getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ExitAction(ActionEvent event) {
         Stage stage = (Stage) rootS.getScene().getWindow();
stage.close(); 
    }

    private void listeArticles(ActionEvent event) {
              try {
            AnchorPane pane  = FXMLLoader.load(getClass().getResource("/Presentation/Articles.fxml"));
            AcceilController.rootS.getChildren().clear();
            AcceilController.rootS.getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listeFicheConsultation(ActionEvent event) {
                 try {
            AnchorPane pane  = FXMLLoader.load(getClass().getResource("/Presentation/ListeFichesConsultation.fxml"));
            AcceilController.rootS.getChildren().clear();
            AcceilController.rootS.getChildren().add(pane);
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
