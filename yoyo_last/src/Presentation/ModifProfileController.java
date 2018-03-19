/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import DB.MyConnexion;
import Entite.Patient;
import Entite.Users;
import Services.ControleSaisie;
import Services.Services_Patient;
import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class ModifProfileController implements Initializable {
    @FXML
    private DatePicker date;
    @FXML
    private TextField nom = new TextField();
    @FXML
    private TextField prenom= new TextField();
    @FXML
    private TextField tel= new TextField();
    @FXML
    private TextField username= new TextField();
    @FXML
    private TextField cin= new TextField();
    @FXML
    private TextField adress= new TextField();
    @FXML
    private Button valider;
    @FXML
    private Button return4;
    @FXML
    private TextField email= new TextField();
    @FXML
    private PasswordField pwd= new PasswordField();
    @FXML
    private PasswordField pwd2;

    public DatePicker getDate() {
        return date;
    }

    public void setDate(DatePicker date) {
        this.date = date;
    }

    public TextField getNom() {
        return nom;
    }

    public void setNom(TextField nom) {
        this.nom = nom;
    }

   

    public TextField getPrenom() {
        return prenom;
    }

    public void setPrenom(TextField prenom) {
        this.prenom = prenom;
    }

    public TextField getTel() {
        return tel;
    }

    public void setTel(TextField tel) {
        this.tel = tel;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public TextField getCin() {
        return cin;
    }

    public void setCin(TextField cin) {
        this.cin = cin;
    }

    public TextField getAdress() {
        return adress;
    }

    public void setAdress(TextField adress) {
        this.adress = adress;
    }

    public Button getReturn4() {
        return return4;
    }

    public void setReturn4(Button return4) {
        this.return4 = return4;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getPwd() {
        return pwd;
    }

    
    public void setPwd(PasswordField pwd) {
        this.pwd = pwd;
    }

  
     Services_Patient cp = new Services_Patient();
                            Users p1 = cp.recherchePatient(1);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
             date.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.DateNullCS(date.getEditor().getText())){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Erreur dans la date ");
                    a1.setContentText("la date dit etre différente de null \n"
                            + "Selectionner une date valide ");
                    a1.show();
                 
                } 
        });
//                   date.addEventHandler(KEY_RELEASED, (e)->{
//            
//                if(ControleSaisie.validate(date.getEditor().getText())){
//                    Alert a1 = new Alert(Alert.AlertType.ERROR);
//                    a1.setTitle("Erreur dans la date ");
//                    a1.setContentText("la date dit etre différente de null \n"
//                            + "Selectionner une date valide ");
//                    a1.show();
//                 
//                } 
//        });
//             //          ******************* Nom ***************
             nom.addEventHandler(KEY_RELEASED, (e)->{
        
                if(ControleSaisie.isString(nom.getText())==false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Erreur dans le nom ");
                    a1.setContentText("le nom ne doit contenir ni des chiffres ni des caractères spéciaux");
                    a1.show();
                    nom.setText(p1.getNom());
                }
    });
             //    ********************** Prenom **********************
                   prenom.addEventHandler(KEY_RELEASED, (e)->{
        
                if(ControleSaisie.isString(prenom.getText())==false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Erreur dans le prenom");
                    a1.setContentText("le nom ne doit contenir ni des chiffres ni des caractères spéciaux");
                    a1.show();
                    prenom.setText(p1.getPrenom());
                }
    });
                   // ***************** USERNAME **************
                   
           username.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.isUsername(username.getText())==false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("   error Username");
                    a1.setContentText("le username n'admet pas de caractéres spec\n");
                    a1.show();
                    username.setText(p1.getUsername());
                }
        });
                  username.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.isNull(username.getText())){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("   error Username");
                    a1.setContentText("Username Can't be null\n");
                    a1.show();
                    username.setText(p1.getUsername());
                }
        });
             // ***************** CIN ***********************
             cin.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.isNull(cin.getText())){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" CIN can't be null");
                    a1.setContentText("veiller verifier votre cin \n");
                    a1.show();
                    cin.setText(""+p1.getCin());
                }
        });
                cin.addEventHandler(KEY_RELEASED, (e)->{
            //ControleSaisie.iscin(cin.getText())
                if( ControleSaisie.iscin(cin.getText())== false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" CIN type error ");
                    a1.setContentText("un cin n'admet pas de caractéres  \n");
                    a1.show();
                    cin.setText(""+p1.getCin());
                }
        });
        
                //  ************************** TELEPHONE *******************
                tel.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.isNull(tel.getText())){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" Numero Telephone");
                    a1.setContentText("le  numéro de téléphone ne peut pas être vide\n");
                    a1.show();
                    tel.setText(""+p1.getTelephone());
                }
        });
                tel.addEventHandler(KEY_RELEASED, (e)->{
            //ControleSaisie.iscin(cin.getText())
                if( ControleSaisie.iscin(cin.getText())== false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" CIN type error ");
                    a1.setContentText("un numero de téléphone  n'admet pas de caractéres  \n");
                    a1.show();
                    tel.setText(""+p1.getCin());
                }
        });
                //      ******************* L'email *********************
        email.addEventHandler(KEY_RELEASED, (e)->{
            //ControleSaisie.iscin(cin.getText())
                if( ControleSaisie.valiemail(cin.getText())== false){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" email type error ");
                    a1.setContentText("l'email n'est pas ecrit correctement \n");
                    a1.show();
                    email.setText("");
                }
        });
          email.addEventHandler(KEY_RELEASED, (e)->{
            //ControleSaisie.iscin(cin.getText())
                if( ControleSaisie.isNull(cin.getText()) ){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" email type error ");
                    a1.setContentText("l'email ne peut pas étre vide \n");
                    a1.show();
                    email.setText("");
                }
        });
       
    }
    @FXML
    private void ModifierAction(ActionEvent event) throws IOException {

         Connection db = MyConnexion.Get_Instance().getCon();
        Services_Patient cr = new Services_Patient();
        Users p = new Patient();
        //1
        p.setNom(nom.getText());
        //2
         p.setPrenom(prenom.getText());
        //3
         p.setAdresse(adress.getText());
        //4
         p.setEmail(email.getText());
        //5
              date.addEventHandler(KEY_RELEASED, (e)->{
            
                if(ControleSaisie.DateNullCS(date.getEditor().getText())){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Erreur dans la date ");
                    a1.setContentText("la date dit etre différente de null \n"
                            + "Selectionner une date valide ");
                    a1.show();
                 
                } 
                      else{
                      p.setDateNaissance(java.sql.Date.valueOf(date.getValue()));
                }
        });
          
     
        //6
            if(cin.getText().length()==8){
                 p.setCin(Integer.parseInt(cin.getText()));
            }
            else{
                 Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle(" CIN composer de 8 chiffre");
                    a1.setContentText("il faut que le cin soit composé de 8 chiffres \n");
                    a1.show();
                    cin.setText(""+p1.getCin());
                p.setCin(Integer.parseInt(cin.getText()));
            }
        
        //7
         p.setTelephone(Integer.parseInt(tel.getText()));
        //8
         p.setUsername(username.getText());
        //9
      
      
        pwd2.addEventHandler(KEY_RELEASED,(e)->{
            
                if(pwd2.getText().compareTo(pwd.getText())!=0){
                    Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Not same password ");
                    a1.setContentText(" il faut resaisir um mot le même mot de passe\n");
                    a1.show();
                    pwd.setText("");
                    pwd2.setText("");
                }else{
                    p.setPassword(pwd.getText());
                }
        });
        
          
        
          
          
       
         
               Parent p1;
         
        try {
             
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
                       a1.setTitle(" Confirmed Add");
                    a1.setContentText("vous avez Modifier Votre Compte ");
                    a1.show();
            p1 = FXMLLoader.load(getClass().getResource("Acceil.fxml"));
            
                     Scene test1 = new Scene(p1);

        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
       
        } catch (IOException ex) {
                 Alert a1 = new Alert(Alert.AlertType.ERROR);
                    a1.setTitle("Modifier failed ");
                    a1.setContentText("les informations que tu est entraint d'ajouter ne peut pas etre "
                            + "traiter veuiller repéter l'insertion aprés"+ex);
                    a1.show();
                      p1 = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            
                     Scene test1 = new Scene(p1);

        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App1.setScene(test1);
        App1.show();
            
        }
        
             
         
         
       
    }

    @FXML
    private void ReturnAction(ActionEvent event) {
        
         FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Profile.fxml"));
        Parent p3;
        try {
            p3 = fxmlLoader.load();
              Scene s3 = new Scene(p3);
        Presentation.ProfileController c = (Presentation.ProfileController) fxmlLoader.getController();
         
                         Services_Patient cp = new Services_Patient();
                            Users uc = cp.recherchePatient(1);
         
        c.getLblnom().setText(uc.getNom());
        c.getLblprenom().setText(uc.getPrenom());
        c.getLblemail().setText(uc.getEmail());

        c.getLblcin().setText(String.valueOf(uc.getCin()));
        c.getLbladresse().setText(uc.getAdresse());
        c.getbltelephone().setText(String.valueOf(uc.getTelephone()));
        c.getLbUsername().setText(uc.getUsername());
        c.getDateNaissance().setText(String.valueOf(uc.getDateNaissance()));
        Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
        } catch (IOException ex) {
            System.out.println("error  in modif profile \n"+ex);
        }
    }
    
}
