/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtek;
import java.util.Properties ;
import javax.mail.Message ;
import javax.mail.Authenticator ;
import javax.mail.MessagingException ;
import javax.mail.PasswordAuthentication ;
import javax.mail.* ;

import Entite.Validation_V ;
import Services.Services_Validation ;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Entite.Patient ;
import Services.Services_Patient ;
import java.io.IOException;
import java.util.Date ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author music
 */
public class Patient_InscriptionController_2 implements Initializable {

   

    @FXML
    private PasswordField p_password;
    @FXML
    private DatePicker p_date_naissance;
    @FXML
    private TextField p_username;
    @FXML
    private TextField p_nom;
    @FXML
    private TextField p_prenom;
    @FXML
    private Label ajout_status;
     @FXML 
     private AnchorPane rootpane ;
    @FXML
    private Button Inscription_button;
    
 String username;
    @FXML
    private Button Acceuil_button;

    /**
     * Initializes the controller class.
     */
    void data()
    {
        username=p_username.getText();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        // TODO
    }    
@FXML
    private void Inscription(ActionEvent event) throws IOException  {
       Properties props=new Properties() ;
       props.put("mail.smtp.host","smtp.gmail.com") ;
       
       props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory") ;
       props.put("mail.smtp.socketFactory.port", "465") ;
       props.put("mail.smtp.socketFactory.fallback", "false") ;
       props.put("mail.smtp.auth","true") ;
       props.put("mail.smtp.password","ntxwlmsoqczjbrrq");
       props.put("mail.smtp.port","465") ;
       
       
       Session session=Session.getDefaultInstance(props,new javax.mail.Authenticator()
       {
           public PasswordAuthentication getPasswordAuthetntication()
           {
               return new PasswordAuthentication("amyral.contact@gmail.com","qfieafzfjgonoggz");
              
           }
           
           
}
       );
       
       
       
               
       
        
        
       
        data() ;
    
        try {
            Services_Patient sp=new Services_Patient() ;
        Services_Validation sv=new Services_Validation() ;
        String s =  p_date_naissance.getEditor().getText();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
        FXMLLoader loader= new FXMLLoader() ;
          
        Parent v_b= loader.load(getClass().getResource("confirmation_box.fxml").openStream())  ;
        Confirmation_boxController out = new Confirmation_boxController() ;
        out = loader.getController();
        out.SetData(username);
        Stage stage=  (Stage) ((Node)event.getSource()).getScene().getWindow() ;
        
     //   Parent root ;
       // Parent root2 ;
      //  root=  FXMLLoader.load(getClass().getResource("confirmation_box.fxml")) ;
       // root2=FXMLLoader.load(getClass().getResource("Acceuil_Auth.fxml")) ;
        
        String name=p_username.getText() ;
            
           java.util.Date date = sdf.parse(s);
           //p_username.getText(),p_password.getText(),p_nom.getText(),p_prenom.getText(),date,"non_confirme"
             Patient p = new Patient(p_nom.getText(), p_prenom.getText(), p_password.getText(), (java.sql.Date)  date,p_username.getText(),"non_confirme");
            System.out.println(p);
        
        if (p.getUsername().isEmpty() || p.getNom().isEmpty() || p.getPassword().isEmpty() || p.getPrenom().isEmpty() || p.getDateNaissance().toString().isEmpty())
        {
            System.out.println("un champ est invalide");
            ajout_status.setText("un champ est invalide");
        }
        else if (sp.check_user(p_username.getText()))
        {
             ajout_status.setText("Le nom d'utilisateur existe deja");
        }
            
       
        else
        {
            sp.inscription_p(p);
            
             Validation_V v = new Validation_V(sp.Id_user(p_username.getText()),sp.Random()) ;
            sv.create(v);
            
            ajout_status.setText("ajout success") ;
            
            int a = sp.code_valid(sp.Id_user(p_username.getText()));
            System.out.println(p_username.getText());
            System.out.println(a);
            try
       {
           
          Message message=new MimeMessage(session) ;
          message.setFrom(new InternetAddress("amir.bennasr@esprit.tn"));
          message.setRecipient(Message.RecipientType.TO, new InternetAddress("amyral.contact@gmail.com"));
          message.setSubject("Sahtek Confirmation code");
          message.setText("votre code de confirmation est "+a+"") ;
          Transport transport = session.getTransport("smtp");
          transport.connect("smtp.gmail.com","amyral.contact@gmail.com","qfieafzfjgonoggz");
          transport.sendMessage(message, message.getAllRecipients());
           JOptionPane.showMessageDialog(null,"Message sent !");
           
       
       } catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
            
       
        /*   Pane Validation_Box = FXMLLoader.load(getClass().getResource("confirmation_box.fxml")) ;
         rootpane.getChildren().addAll(Validation_Box) ;
            */
       
         stage.setScene(new Scene(v_b));
        stage.initModality(Modality.APPLICATION_MODAL);
         
         stage.showAndWait();
       
          
     
            
            
        }
            
        } catch (ParseException ex) {
            Logger.getLogger(Patient_InscriptionController_2.class.getName()).log(Level.SEVERE, null, ex);
            ajout_status.setText("Un champ est vide");
        }
      
        
    }
    
    
    public String return_usenrame()
    {
       return p_username.getText() ;
    }

    @FXML
    private void Go_Acceuil(ActionEvent event) throws IOException {
       Parent Patient_parent = FXMLLoader.load(getClass().getResource("Acceuil_Auth.fxml")) ;
            Scene patient_scene =new Scene(Patient_parent) ;
            Stage app_stage = (Stage) ( (Node) event.getSource()).getScene().getWindow() ;
            
            app_stage.setScene(patient_scene);
            app_stage.show();
    }
    
    
        
    }

  
    

