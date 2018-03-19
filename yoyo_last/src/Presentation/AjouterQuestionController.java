/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import Entite.Articles;
import Entite.Patient;
import Services.ControleSaisie;
import Services.Services_Patient;
import Services.ServicesArticle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class AjouterQuestionController implements Initializable {
    @FXML
    private Button bt7;
    @FXML
    private TextField image;
    @FXML
    private TextArea descript;
    @FXML
    private TextField titre;
    @FXML
    private TextField sub_t;
    @FXML
    private Button bt9;
    @FXML
    private Button ImageUpload;
    private Window chooserWindow ;
      public TextField getImage() {
        return image;
    }  public void setImage(TextField image) {
        this.image = image;
    } public TextArea getDescript() {
        return descript;
    }

    public void setDescript(TextArea descript) {
        this.descript = descript;
    }  public TextField getTitre() {
        return titre;
    } public void setTitre(TextField titre) {
        this.titre = titre;
    }

    public TextField getSub_t() {
        return sub_t;
    } public void setSub_t(TextField sub_t) {
        this.sub_t = sub_t;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              titre.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.adresse(titre.getText())==false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("   error de titre");
                    a1.setContentText("le titre n'admet pas de caractéres spec\n");
                    a1.show();
                    titre.setText("");
                }
        });
                  titre.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.isNull(titre.getText())){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("   error Titre");
                    a1.setContentText("Title Can't be null\n");
                    a1.show();
                    
                }
        });
                         sub_t.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.adresse(sub_t.getText())==false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("   error de titre");
                    a1.setContentText("le titre n'admet pas de caractéres spec\n");
                    a1.show();
                    sub_t.setText("");
                }
        });
            
                                descript.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.adresse(descript.getText())==false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("   error dans la description");
                    a1.setContentText("le titre n'admet pas de caractéres spec\n");
                    a1.show();
                    descript.setText("");
                }
        });
            
                  
                  
             
    }    

    @FXML
    private void Avance1(ActionEvent event) {
         
         Services_Patient cp = new Services_Patient();
      Patient p = cp.recherchePatient(1);
   
        Services.ServicesArticle sa = new ServicesArticle();
        Articles a = new Articles();
        a.setTitre(titre.getText());
        a.setSub_t(sub_t.getText());
        a.setDescript(descript.getText());
        a.setImage(image.getText());
        sa.ajouterArticle(p, a);
             Parent p1;
        try {
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
                       a1.setTitle(" Confirmed Add");
                    a1.setContentText("vous avez ajouter créer un article ");
                    a1.show();
            p1 = FXMLLoader.load(getClass().getResource("Articles.fxml"));
             Scene test1 = new Scene(p1);
        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
        } catch (IOException ex) {
            System.out.println("\n"+ex);
        }
       
    }

    @FXML
    private void annnule1(ActionEvent event) {
        try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("Profile.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt9.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void ImageUpload(ActionEvent event) {
          FileChooser changeImg = new FileChooser();
		changeImg.setTitle("badel taswira");
		changeImg.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		File selectedFile = changeImg.showOpenDialog(chooserWindow);
		if (selectedFile != null) {
			try {
				File dest = new File("C:\\xampp\\htdocs\\images\\"+selectedFile.getName());
				Files.copy(selectedFile.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
				
                                System.out.println(selectedFile.toPath());
                          
                                File imgFile = new File(""+selectedFile.toPath()+"");
                                Image image1 = new Image(imgFile.toURI().toString());
                               image.setText(selectedFile.getName());
                                       
                               
	        } catch (IOException ex) {
	        	System.err.println(ex);
	        }
        
        
    }
    }
    
}
