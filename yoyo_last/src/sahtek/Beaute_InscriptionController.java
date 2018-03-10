/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtek;

import Entite.Beaute;
import Entite.Patient;
import Entite.Validation_V;
import Services.Services_Beaute;
import Services.Services_Patient;
import Services.Services_Validation;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author music
 */
public class Beaute_InscriptionController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private TextField p_username;
    @FXML
    private TextField p_nom;
    @FXML
    private TextField p_prenom;
    @FXML
    private PasswordField p_password;
    @FXML
    private DatePicker p_date_naissance;
    @FXML
    private Button Inscription_button;
    @FXML
    private Label ajout_status;
    @FXML
    private Button Acceuil_button;
String username ;
    @FXML
    private Button Boutton_Upload;
    @FXML
    private Label Pro_label;
    private File file  ;
    FileInputStream img ;
    FileChooser file_choser=new FileChooser() ;
    @FXML
    private TextField img_loc;
     
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  System.out.println(file);
        // TODO
    }    
     void data()
    {
        username=p_username.getText();
    }

    @FXML
    private void Inscription(ActionEvent event) throws IOException {
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
            Services_Beaute sp=new Services_Beaute() ;
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
   
           
           //p_username.getText(),p_password.getText(),p_nom.getText(),p_prenom.getText(),date,"non_confirme",img
           
             Beaute b = new Beaute(img, p_nom.getText(), p_prenom.getText(), p_password.getText(), (Date) date, p_username.getText(), "non_confirme");
            System.out.println(b);
        
        if (b.getUsername().isEmpty() || b.getNom().isEmpty() || b.getPassword().isEmpty() || b.getPrenom().isEmpty() || b.getDateNaissance().toString().isEmpty())
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
             
            System.out.println(img.toString());
            sp.inscription_b(b);
            
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

    @FXML
    private void Go_Acceuil(ActionEvent event) {
    }

    @FXML
    private void Afficher_info(MouseEvent event) {
        
      Pro_label.setTooltip(new Tooltip("Inserer votre image de carte pro , pour que votre compte soit Verifié")) ;
    }

    @FXML
    private void upload_image(ActionEvent ae) throws FileNotFoundException {
 Node source = (Node) ae.getSource();
  Window theStage = source.getScene().getWindow();
  file= file_choser.showOpenDialog(theStage);
  if (file!=null)
  {
  img_loc.setText(file.toString());
     
      
      
      
        
    }
    } 
}
