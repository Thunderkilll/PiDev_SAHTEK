/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import DB.MyConnexion;
import Entite.FichePatient;
import Services.ServicesFiche;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class ModifierFicheController implements Initializable {
    @FXML
    private Button bt2;
    @FXML
    private Button bt1;
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

    public DatePicker getDateRDV() {
        return dateRDV;
    }  public void setDateRDV(DatePicker dateRDV) {
        this.dateRDV = dateRDV;
    } public TextArea getDiagnostique() {
        return diagnostique;
    }

    public void setDiagnostique(TextArea diagnostique) {
        this.diagnostique = diagnostique;
    } public TextField getMed() {
        return med;
    } public void setMed(TextField med) {
        this.med = med;
    }

    public TextField getNom_m() {
        return nom_m;
    } public void setNom_m(TextField nom_m) {
        this.nom_m = nom_m;
    } public TextField getPrenom_p() {
        return prenom_p;
    }

    public void setPrenom_p(TextField prenom_p) {
        this.prenom_p = prenom_p;
    }  public TextField getNom_p() {
        return nom_p;
    }  public void setNom_p(TextField nom_p) {
        this.nom_p = nom_p;
    }

    public Label getId_fiche() {
        return id_fiche;
    }    public void setId_fiche(Label id_fiche) {
        this.id_fiche = id_fiche;
    }

    
    
    Services.ServicesFiche sf = new ServicesFiche();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierFiche(ActionEvent event) {
        
         Connection db = MyConnexion.Get_Instance().getCon();
        FichePatient b = new FichePatient();
       b.setNom(nom_p.getText());
       b.setMaldaie(nom_m.getText());
       b.setPrenom(prenom_p.getText());
       b.setDiagnostique(diagnostique.getText());
       b.setTraitement(med.getText());
       b.setDate(java.sql.Date.valueOf(dateRDV.getValue()));
       b.setId_fiche(Integer.valueOf(id_fiche.getText()));
        try {
           
     sf.UpdateFiche(b.getId_fiche(), b);
        } catch (Exception e) {
        }
       
          Parent p1;
         
        try {
             
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
                       a1.setTitle(" Confirmed Add");
                    a1.setContentText("vous avez Modifier Votre fiche de consultation portant le numero : "+b.getId_fiche());
                    a1.show();
            p1 = FXMLLoader.load(getClass().getResource("ListeFichesConsultation.fxml"));
            
                     Scene test1 = new Scene(p1);

        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
       
        } catch (IOException ex) {
            System.out.println("error in this modifier profile "+ex);
        }
        
        
    }

    @FXML
    private void ReturnToList(ActionEvent event) {
            try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("ListeFichesConsultation.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt1.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }
   
    
}
