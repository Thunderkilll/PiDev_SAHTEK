/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.FichePatient;
import Entite.Patient;
import Services.ServicesFiche;
import Services.Services_Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class AffichageFicheController implements Initializable {
    @FXML
    private Label id_fiche;
    @FXML
    private Label lbnom;
    @FXML
    private Label lbprenom;
    @FXML
    private Label lbmaladie;
    @FXML
    private Label lbtraitement;
    @FXML
    private Label lbdesc;
    @FXML
    private Label lbdate;
    @FXML
    private Button pdf;
    @FXML
    private ImageView retour;
    @FXML
    private Button btSupp;
       
  Services_Patient cp = new Services_Patient();
                            Patient p1 = cp.recherchePatient(1);
  Services.ServicesFiche cf = new ServicesFiche();
  
                           
    public Label getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(Label id_fiche) {
        this.id_fiche = id_fiche;
    }

    public Label getLbnom() {
        return lbnom;
    }

    public void setLbnom(Label lbnom) {
        this.lbnom = lbnom;
    }

    public Label getLbprenom() {
        return lbprenom;
    }

    public void setLbprenom(Label lbprenom) {
        this.lbprenom = lbprenom;
    }

    public Label getLbmaladie() {
        return lbmaladie;
    }

    public void setLbmaladie(Label lbmaladie) {
        this.lbmaladie = lbmaladie;
    }

    public Label getLbtraitement() {
        return lbtraitement;
    }

    public void setLbtraitement(Label lbtraitement) {
        this.lbtraitement = lbtraitement;
    }

    public Label getLbdesc() {
        return lbdesc;
    }

    public void setLbdesc(Label lbdesc) {
        this.lbdesc = lbdesc;
    }

    public Label getLbdate() {
        return lbdate;
    }

    public void setLbdate(Label lbdate) {
        this.lbdate = lbdate;
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void GeneratePDF(ActionEvent event) {
    
//       
    }

    @FXML
    private void ReturnAction(MouseEvent event) {
          FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Presentation/ListeFichesConsultation.fxml"));
        Parent p3;
        try {
            p3 = fxmlLoader.load();
              Scene s3 = new Scene(p3);
     
        Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
        } catch (IOException ex) {
            System.out.println("vraiment choqué minnik \n"+ex);
        }
    }

    @FXML
    private void DeleteAction(ActionEvent event) {
        FichePatient f = cf.ChercherFiche1(Integer.valueOf(id_fiche.getText()));
           Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Suppression Warning !!!");
            a.setContentText("Vous ête entrain de supprimer un fichier numero  :"+f.getId_fiche());
            a.show();
            
                   try {
                       cf.DeleteAction(p1,f);
                 Parent p1 = FXMLLoader.load(getClass().getResource("ListeFichesConsultation.fxml"));
            
                     Scene test1 = new Scene(p1);

        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
       
                //button1.getParent()
            } catch (IOException ex) {System.out.println("\n \n"+ex);
               
            }
                
            }
        }
     
        
    
    
