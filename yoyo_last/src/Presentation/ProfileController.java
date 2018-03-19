/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import Entite.Patient;
import Entite.Users;
import Services.Services_Patient;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class ProfileController implements Initializable {
    @FXML
    private AnchorPane profile;
    @FXML
    private ImageView imgProf;
    @FXML
    private Label lblnom;
    @FXML
    private Label lblprenom;
    @FXML
    private Label lblcin;
    @FXML
    private Label lblemail;
    @FXML
    private Label lbltelephone;
    @FXML
    private Label lbladresse;
    @FXML
    private Button bt11;
    @FXML
    private Button bt13;
    @FXML
    private Button bt12;
    @FXML
    private Button bt10;
    @FXML
    private Button bt15;
    @FXML
    private Button btImg;
    @FXML
    private Label lbUsername;
    @FXML
    private Label dateNaissance;
     private Window chooserWindow ;

    public ImageView getImgProf() {
        return imgProf;
    }

    public void setImgProf(ImageView imgProf) {
        this.imgProf = imgProf;
    }
     
    public Label getLblnom() {
        return lblnom;
    }

    public void setLblnom(Label lblnom) {
        this.lblnom = lblnom;
    }

    public Label getLblprenom() {
        return lblprenom;
    }

    public void setLblprenom(Label lblprenom) {
        this.lblprenom = lblprenom;
    }

    public Label getLblcin() {
        return lblcin;
    }

    public void setLblcin(Label lblcin) {
        this.lblcin = lblcin;
    }

    public Label getLblemail() {
        return lblemail;
    }

    public void setLblemail(Label lblemail) {
        this.lblemail = lblemail;
    }   

    public Label getbltelephone() {
        return lbltelephone;
    }

    public void setLbltelephone(Label lbltelephone) {
        this.lbltelephone = lbltelephone;
    }

    public Label getLbladresse() {
        return lbladresse;
    }

    public void setLbladresse(Label lbladresse) {
        this.lbladresse = lbladresse;
    }

    public Label getLbUsername() {
        return lbUsername;
    }

    public void setLbUsername(Label lbUsername) {
        this.lbUsername = lbUsername;
    }

    public Label getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Label dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    

    public ProfileController() {
    }
    
  Services_Patient cp = new Services_Patient();
                            Patient p1 = cp.recherchePatient(1);
                           
   public void UserName(String s){
        try {
            lbUsername.setText(s);
        } catch (NullPointerException e) {
            System.out.println("here is the problem");
        }
   }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
                transFade(lbUsername);   transFade(lbladresse);   transFade(lblcin);   transFade(lblemail);   transFade(lblnom);
                  transFade(lblprenom);     transFade(lbltelephone);
                    transFade(profile); 
                 
//                          File file = new File(cp.ImageConverter(p1.getImage()));
//                          //System.out.println(p1.getImage());
//        Image image = new Image(file.toURI().toString());
//       imgProf.setImage(image);
//      
    }    

     public void transFade(Node object )
    {
        FadeTransition transition = new FadeTransition(Duration.seconds(3), (Node) object);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);
        transition.play();
    }
    @FXML
    private void ListeRDV(ActionEvent event) {
    }

    @FXML
    private void ArticlesAction(ActionEvent event) {
         try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("Articles.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt13.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void UpdateAction(ActionEvent event) {
         try {
//                
             
           FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ModifProfile.fxml"));
        Parent p3;
         p3 = fxmlLoader.load();
              Scene s3 = new Scene(p3);
              Presentation.ModifProfileController mc = (Presentation.ModifProfileController) fxmlLoader.getController();
                            Services.Services_Patient cp = new Services_Patient();
                            Users uc = cp.recherchePatient(1);
        
                          mc.getNom().setText(uc.getNom());
        mc.getPrenom().setText(uc.getPrenom());
        mc.getEmail().setText(uc.getEmail());
        mc.getCin().setText(String.valueOf(uc.getCin()));
        mc.getAdress().setText(uc.getAdresse());
        mc.getTel().setText(String.valueOf(uc.getTelephone()));
        mc.getUsername().setText(uc.getUsername());
        //mc.getDate().setDayCellFactory((Callback<DatePicker, DateCell>) (uc.getDateNaissance()));
        mc.getDate().getEditor().setText(String.valueOf(uc.getDateNaissance()));
        Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
        
    }

    @FXML
    private void F_ConsultAction(ActionEvent event) {
         try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("../Presentation/ListeFichesConsultation.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt10.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void versaccueilAction(ActionEvent event) {
              try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("Acceil.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt15.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void updateImageAction(ActionEvent event) {
        FileChooser changeImg = new FileChooser();
		changeImg.setTitle("badel taswira");
		changeImg.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		File selectedFile = changeImg.showOpenDialog(chooserWindow);
		if (selectedFile != null) {
			try {
				File dest = new File("C:\\xampp\\htdocs\\images\\"+selectedFile.getName());
				Files.copy(selectedFile.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
				//imgProf.setText(selectedFile.toPath().toString());
                              //  p1.setImage(.toString());
                                System.out.println(selectedFile.toPath());
                            //  String path ="C:\\xampp\\htdocs\\images\\"+selectedFile.toPath().toString();
                             // System.out.println(path);
                             
                                File imgFile = new File(""+selectedFile.toPath()+"");
                                Image image = new Image(imgFile.toURI().toString());
                                imgProf.setImage(image);
				         cp.ajouterImage(p1, selectedFile.getName());          
                                       
                               
	        } catch (IOException ex) {
	        	System.err.println(ex);
	        }
        
        
    }
    }
    }
     
        

