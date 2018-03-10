/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DB.MyConnexion;
import Entite.FichePatient;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class CreeFicheController implements Initializable {
    @FXML
    private Button bt21_2;
    @FXML
    private Button bt21_1;
    @FXML
    private DatePicker dateRDV;
    @FXML
    private TextArea diagnostique;
    @FXML
    private TextField med;
    @FXML
    private TextField nom_m;
    @FXML
    private TextField prenom_p;
    @FXML
    private TextField nom_p;
    @FXML
    private Label id_fiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retourAction(ActionEvent event) {
           try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("ListeFichesConsultation.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt21_2.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void ajouterAction(ActionEvent event) {
         Connection db = MyConnexion.Get_Instance().getCon();
       FichePatient f = new FichePatient();
       f.setNom(nom_p.getText());
       f.setPrenom(prenom_p.getText());
       f.setMaldaie(nom_m.getText());
       f.setTraitement(med.getText());
       f.setDiagnostique(diagnostique.getText());
       
     
         java.sql.Date date = java.sql.Date.valueOf(dateRDV.getValue());
         f.setDate(date);
            Services.ServicesFiche sf = new Services.ServicesFiche();
           try {
            sf.AjouterFiche(f);
               System.out.println("ajouter ");
               
        } catch (Exception e) {
               System.out.println("ajout isn't done !"+e);
       
               
               }
      
          Parent p1;
        try {
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
                       a1.setTitle(" Confirmed Add");
                    a1.setContentText("vous avez ajouter créer une fiche Patient ");
                    a1.show();
            p1 = FXMLLoader.load(getClass().getResource("ListeFichesConsultation.fxml"));
             Scene test1 = new Scene(p1);
        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
        } catch (IOException ex) {
            Logger.getLogger(CreeFicheController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
}
}