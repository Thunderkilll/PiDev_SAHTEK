/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DB.MyConnexion;
import Entite.Articles;
import Entite.Users;
import Services.ControleSaisie;
import Services.Services_Patient;
import Services.ServicesArticle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.css.StyleOrigin;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class ModifierArticleController implements Initializable {
    @FXML
    private TextField titre;
    @FXML
    private TextField Sub_t;
    @FXML
    private TextArea descript;
    @FXML
    private TextField image;
    @FXML
    private Button bt19;
    @FXML
    private Button bt20;
    @FXML
    private Button btIm;
    Services_Patient cp = new Services_Patient();
                            Users p1 = cp.recherchePatient(1);
    @FXML
    private Label id;

    public Label getId() {
        return id;
    }

    public void setId(Label id) {
        this.id = id;
    }


    public TextField getTitre() {
        return titre;
    }

    public void setTitre(TextField titre) {
        this.titre = titre;
    }

    public TextField getSub_t() {
        return Sub_t;
    }

    public void setSub_t(TextField Sub_t) {
        this.Sub_t = Sub_t;
    }

    public TextArea getDescript() {
        return descript;
    }

    public void setDescript(TextArea descript) {
        this.descript = descript;
    }

    public TextField getImage() {
        return image;
    }

    public void setImage(TextField image) {
        this.image = image;
    }
     Articles e = new Articles();
     int a =0;
      Services.ServicesArticle sa = new ServicesArticle();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Controle de saisies
     titre.addEventHandler(EventType.ROOT, (e)->{
          if(ControleSaisie.isNull(titre.getText())){
              Alert titreX = new Alert(Alert.AlertType.ERROR);
              titreX.setTitle("Erreur dans le Titre");
              titreX.setContentText("Avant de quitter le champs de titre il faut assurer\nque le champs n'est pas vide s'il vous plait");
              titreX.show();
              
          }
     
     });
       titre.addEventHandler(EventType.ROOT, (e)->{
          if(!ControleSaisie.isString(titre.getText()) ){
              Alert titreX = new Alert(Alert.AlertType.ERROR);
              titreX.setTitle("Erreur dans le Titre");
              titreX.setContentText("Le Tire doit être ecrit avec seulement des lettre\n n'utilise pas des caractéres spéciaux");
              titreX.show();
          }
     
     });
    }    

    @FXML
    private void ConfirmAction(ActionEvent event) {
         Connection db = MyConnexion.Get_Instance().getCon();
        Articles b = new Articles();
        System.out.println(p1.getId_usr());
         b.setTitre(titre.getText());
         b.setSub_t(Sub_t.getText());
         b.setDescript(descript.getText());
         b.setImage(image.getText());
         System.out.println(id.getText());
      // b.setId(Integer.valueOf(id.getText()));
          sa.updateArticle(Integer.valueOf(id.getText()),b);
       
        
          Parent p1;
         
        try {
             
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
                       a1.setTitle(" Confirmed Add");
                    a1.setContentText("vous avez Modifier Votre Compte ");
                    a1.show();
            p1 = FXMLLoader.load(getClass().getResource("Articles.fxml"));
            
                     Scene test1 = new Scene(p1);

        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
       
        } catch (IOException ex) {
            System.out.println("error in this modifier profile "+ex);
        }
        
    }

    @FXML
    private void RetourVersArticles(ActionEvent event) {
         try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("Articles.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt20.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

   
    
    public int IdRech(int id)
    {
        return id ;
    }
private Window chooserWindow ;
    @FXML
    private void UploadImage(ActionEvent event) {
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
