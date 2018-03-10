/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Articles;
import Entite.FichePatient;
import Entite.Patient;
import Services.ServicesArticle;
import Services.Services_Patient;
import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class AffichageQuestionController implements Initializable {
    @FXML
    private AnchorPane AffarticlePane;
    @FXML
    private Label titre;
    @FXML
    private Label sub_t;
    @FXML
    private ImageView imgQuestion;
    @FXML
    private Button repondre;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private JFXDialogLayout reponces;
    @FXML
    private Label descript;
    @FXML
    private Label id_article;
    @FXML
    private Button retour;

    public Label getTitre() {
        return titre;
    }

    public void setTitre(Label titre) {
        this.titre = titre;
    }

    public Label getSub_t() {
        return sub_t;
    }

    public void setSub_t(Label sub_t) {
        this.sub_t = sub_t;
    }

    public ImageView getImgQuestion() {
        return imgQuestion;
    }

    public void setImgQuestion(ImageView imgQuestion) {
        this.imgQuestion = imgQuestion;
    }

    public Label getDescript() {
        return descript;
    }

    public void setDescript(Label descript) {
        this.descript = descript;
    }

    public Label getId_article() {
        return id_article;
    }

    public void setId_article(Label id_article) {
        this.id_article = id_article;
    }


    
       Services.ServicesArticle ca = new ServicesArticle();
  Services_Patient cp = new Services_Patient();
                            Patient p1 = cp.recherchePatient(1);
                           

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        // TODO
        
    }    

    @FXML
    private void modifierAction(ActionEvent event) {
     int i = Integer.valueOf(id_article.getText());
         try {
              
           FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../Presentation/ModifierArticle.fxml"));
        Parent p3;
        
                    p3 = fxmlLoader.load();
          
              Scene s3 = new Scene(p3);
              Presentation.ModifierArticleController mc = (Presentation.ModifierArticleController) fxmlLoader.getController();
                    
                   //   Articles ps = ca.rechercheArticle(i);
                
                 mc.getTitre().setText(titre.getText());
                mc.getSub_t().setText(sub_t.getText());
                  mc.getDescript().setText(descript.getText());
                  //mc.getImage().setText(imgQuestion.getImage().toString());
                  mc.getId().setText(id_article.getText());
             
             
         
           
                    
                 
             Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
       
       
          
//     
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void supprimerAction(ActionEvent event) {
     /*    Articles ar = ca.rechercheArticle(Integer.valueOf(id_article.getText()));
           Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Suppression Warning !!!");
            a.setContentText("Vous ête entrain de supprimer la question numero  :"+ar.getId()+" de vos propre question "+p1.getNom());
            a.show();
            
                   try {
                       ca.deleteArticle(p1,Integer.valueOf(id_article.getText()));
                 Parent p1 = FXMLLoader.load(getClass().getResource("Articles.fxml"));
            
                     Scene test1 = new Scene(p1);

        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
       
                //button1.getParent()
            } catch (IOException ex) {System.out.println("\n \n"+ex);
               
            }
             */
    }

    @FXML
    private void ReurnAction(ActionEvent event) {
        try {
        Parent p1 = FXMLLoader.load(getClass().getResource("Articles.fxml"));
        Scene scene = new Scene(p1);
        Stage sageMode = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sageMode.setScene(scene);
        sageMode.show();
        } catch (IOException ex) {
            System.out.println("IoExcepion in return Articles");
        }
    }
    
}
