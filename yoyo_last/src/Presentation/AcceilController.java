/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import Entite.Patient;
import Entite.Users;
import Services.Services_Patient;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author samie
 */
public class AcceilController implements Initializable {
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt5;
    @FXML
    private JFXHamburger menuBTN;
    @FXML
    private JFXDrawer menu;
    public static AnchorPane rootS;
    @FXML
    private AnchorPane root;
    @FXML
    private Button btSoin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        transFade(root); 
     rootS = root;

         
        
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/Presentation/Menu.fxml"));
            menu.setSidePane(box);
        } catch (IOException ex) {
          
        }
        
        
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menuBTN);
        transition.setRate(-1);
        menuBTN.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();
            
            if(menu.isShown())
            {
                menu.close();
            }else
                menu.open();
        });
        
    }    
          public void transFade(Node object )
    {
        FadeTransition transition = new FadeTransition(Duration.seconds(2), (Node) object);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);
        transition.play();
    }
        

    @FXML
    private void redirectionProf(ActionEvent event) {
          
           FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Profile.fxml"));
        Parent p3;
        try {
            p3 = fxmlLoader.load();
              Scene s3 = new Scene(p3);
        ProfileController c = (ProfileController) fxmlLoader.getController();
         
                            Services_Patient cp = new Services_Patient();
                            Patient uc = cp.recherchePatient(1);
         
        c.getLblnom().setText(uc.getNom());
        c.getLblprenom().setText(uc.getPrenom());
        c.getLblemail().setText(uc.getEmail());

        c.getLblcin().setText(String.valueOf(uc.getCin()));
        c.getLbladresse().setText(uc.getAdresse());
        c.getbltelephone().setText(String.valueOf(uc.getTelephone()));
        c.getLbUsername().setText(uc.getUsername());
        c.getDateNaissance().setText(String.valueOf(uc.getDateNaissance()));
          File file = new File(cp.ImageConverter(uc.getImage()));
          Image image = new Image(file.toURI().toString());
        c.getImgProf().setImage(image);
        
        
        
        
        
        Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
        } catch (IOException ex) {
            System.out.println("error in acceuil \n"+ex);
        }
      
    }

    @FXML
    private void Articles(ActionEvent event) {
           try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("ListeQuestions.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt1.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
               
            }
    }

    @FXML
    private void AideAction(ActionEvent event) {
        
    }
   private void exitMenu() {

          if(menu.isShown())
            {
                menu.close();
            }
        }
    
   private void startMenu() {

          
                menu.open();
            
        }

    @FXML
    private void RedirectionSoin(ActionEvent event) {
         try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("interface4.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt1.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
               
            }
        
    }

    
}

