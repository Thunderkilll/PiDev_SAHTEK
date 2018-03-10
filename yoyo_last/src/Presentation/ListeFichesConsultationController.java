/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.FichePatient;
import Entite.Text2Pdf;
import Entite.Users;
import Services.Services_Patient;
import Services.ServicesFiche;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class ListeFichesConsultationController implements Initializable {
   @FXML  private TableColumn <FichePatient, String> nom;
   @FXML  private TableColumn <FichePatient, String>prenom;
  @FXML   private TableColumn<FichePatient, String> Nom_Maladie;
 @FXML    private TableColumn<FichePatient, String> medicaments;
 @FXML    private TableColumn<FichePatient, String>descr;
 @FXML    private TableColumn<FichePatient, Date> date;
  @FXML   private TableView<FichePatient> tableView;
 @FXML    private TableColumn<FichePatient, Integer> id_fiche;
     @FXML  private Button bt16;
   @FXML private TextField tf1;
    ArrayList<FichePatient> fp = new ArrayList<>();
     private ObservableList<FichePatient> data ; 
     ServicesFiche f = new ServicesFiche();
  
   
@FXML
    private Button pdf;
    @FXML
    private Button bt14;
    @FXML
    private Button bt24;
    @FXML
    private Button bt30;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Services.ServicesFiche sf = new ServicesFiche();

        ObservableList<FichePatient> sk = FXCollections.observableArrayList(sf.AfficherFiche());
            data = FXCollections.observableArrayList();
        ArrayList<FichePatient> ls = sf.AfficherFiche();
        ls.stream().forEach((j)->{
            data.add(j);
        });
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         Nom_Maladie.setCellValueFactory(new PropertyValueFactory<>("maldaie"));
                                                    medicaments.setCellValueFactory(new PropertyValueFactory<>("traitement"));
         descr.setCellValueFactory(new PropertyValueFactory<>("Diagnostique"));
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
          id_fiche.setCellValueFactory(new PropertyValueFactory<>("id_fiche"));
          
                                        tableView.setItems(null);
                                        tableView.setItems(data);
        // TODO
    }    

    @FXML
    private void RetourAction(ActionEvent event) {
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
            System.out.println("vraiment choqué minnik \n"+ex);
        }
    }

    @FXML
    private void AjouterAction2(ActionEvent event) {
         try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("../Presentation/CreeFiche.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt16.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
    }

    @FXML
    private void modifierAction(ActionEvent event) {
        
           
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ModifierFiche.fxml"));
        Parent p3;
             try {
            p3 = fxmlLoader.load();
      
               FichePatient ps1 =tableView.getSelectionModel().getSelectedItem();
    
             FichePatient ps = f.ChercherFiche1(ps1.getId_fiche());

      
              Scene s3 = new Scene(p3);
              Presentation.ModifierFicheController mc = (Presentation.ModifierFicheController) fxmlLoader.getController();
         
                    
              mc.getNom_p().setText(ps.getNom());
              mc.getPrenom_p().setText(ps.getPrenom());
              mc.getNom_m().setText(ps.getMaldaie());
              mc.getMed().setText(ps.getTraitement());
              mc.getDiagnostique().setText(ps.getDiagnostique());
              mc.getDateRDV().getEditor().setText(String.valueOf(ps.getDate()));
             mc.getId_fiche().setText(String.valueOf(ps.getId_fiche()));
              
                Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
       
              }
         
            catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
            
            alert.setTitle("No ID found");
            alert.setHeaderText("ID du fiche n'existe pas ");
            alert.setContentText("Please search a valable Document");

            alert.showAndWait();
            tf1.setText("");
               
            }
    }

//    private void chercherAction(ActionEvent event) {
//        Parent p1;   
//   
//         
//        try {
//           FichePatient ps = f.ChercherFiche(tf1.getText());   
//    int id = ps.getId_fiche();
//     if(id!=0){
//             
//            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
//                       a1.setTitle("Fiche trouvée");
//                    a1.setContentText(ps.toString());
//                    a1.show();
//            p1 = FXMLLoader.load(getClass().getResource("ListeFichesConsultation.fxml"));
//            
//                     Scene test1 = new Scene(p1);
//
//        Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        App1.setScene(test1);
//        App1.show();
//        }else{
//           Alert alert = new Alert(Alert.AlertType.WARNING);
//            
//            alert.setTitle("No Name found");
//            alert.setHeaderText("Nom du patient n'existe pas ");
//            alert.setContentText("Please search a name of a patient or create a new fiche with this name ");
//
//            alert.showAndWait();
//            tf1.setText("");
//     }
//
//         
//        } catch (IOException ex) {
//             Alert alert = new Alert(Alert.AlertType.WARNING);
//            
//            alert.setTitle("No Name found");
//            alert.setHeaderText("Nom du patient n'existe pas ");
//            alert.setContentText("Please search a name of a patient or create a new fiche with this name ");
//
//            alert.showAndWait();
//        }
//                    
//                 
//        
//        
//    }

    @FXML
    private void GeneratePDF(ActionEvent event) {
             try {
            FichePatient ps = f.ChercherFiche(tf1.getText());
           Text2Pdf p = new  Text2Pdf();

            p.Test2PdfFunction(ps);

        } catch (Exception e) {
        }
         
           Parent p1;
         
        try {
             
            Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
                       a1.setTitle(" PDF created");
                    a1.setContentText("you will find the pdf C:\\Users\\khaled22\\Desktop\\3A7_Sem2\\pi dev\\Test\\src\\pdfExtrait\\TonName_TonPrenom.PDF ");
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
    private void AfficherFicheAction(ActionEvent event) {
           
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AffichageFiche.fxml"));
        Parent p3;
       try {
           p3 = fxmlLoader.load();
           
               FichePatient ps1 =tableView.getSelectionModel().getSelectedItem();
    
             FichePatient ps = f.ChercherFiche1(ps1.getId_fiche());
             Scene s3 = new Scene(p3);
              Presentation.AffichageFicheController mc = (Presentation.AffichageFicheController) fxmlLoader.getController();
                     
              mc.getLbnom().setText(ps.getNom());
              mc.getLbprenom().setText(ps.getPrenom());
              mc.getLbmaladie().setText(ps.getMaldaie());
              mc.getLbtraitement().setText(ps.getTraitement());
              mc.getLbdesc().setText(ps.getDiagnostique());
              mc.getLbdate().setText(String.valueOf(ps.getDate()));
             mc.getId_fiche().setText(String.valueOf(ps.getId_fiche()));
              
                Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
             
       } catch (IOException ex) {
          // Logger.getLogger(ListeFichesConsultationController.class.getName()).log(Level.SEVERE, null, ex);
              Alert alert = new Alert(Alert.AlertType.WARNING);
            
           alert.setTitle("No ID found");
            alert.setHeaderText("ID du fiche n'existe pas ");
            alert.setContentText("Please search a valable Document");

            alert.showAndWait();
           // tf1.setText("");
       }
      
        
    }
    
     public ProgressIndicator prog;
     
    public void afficherMat() {

        Task<ArrayList<FichePatient>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                
                    fp  = f.AfficherFiche();//a creer
               
                return fp;
            }
        };
        task.setOnSucceeded(e -> {
           
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         Nom_Maladie.setCellValueFactory(new PropertyValueFactory<>("maldaie"));
                                                    medicaments.setCellValueFactory(new PropertyValueFactory<>("traitement"));
         descr.setCellValueFactory(new PropertyValueFactory<>("Diagnostique"));
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
          id_fiche.setCellValueFactory(new PropertyValueFactory<>("id_fiche"));
          
                                        tableView.setItems(null);
                                        tableView.setItems(data);
                                   //  tableb.setItems(FXCollections.observableArrayList(task.getValue()));
        }
                 );
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
                //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
               
                ObservableList<FichePatient> sk = FXCollections.observableArrayList(f.AfficherFiche());
                data = FXCollections.observableArrayList();
                ArrayList<FichePatient> ls = f.AfficherFiche();
                ls.stream().forEach((FichePatient j)->{
                    data.add(j);
                });
                  
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         Nom_Maladie.setCellValueFactory(new PropertyValueFactory<>("maldaie"));
                                                    medicaments.setCellValueFactory(new PropertyValueFactory<>("traitement"));
         descr.setCellValueFactory(new PropertyValueFactory<>("Diagnostique"));
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
          id_fiche.setCellValueFactory(new PropertyValueFactory<>("id_fiche"));
          
                                        tableView.setItems(null);
                                        tableView.setItems(data);
       
                                         prog.setVisible(false);
            }
        });
        Thread th = new Thread(task);
        th.start();
    }
    
 public void afficherMat1() {

        Task<ArrayList<FichePatient>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                    String nom_patien = tf1.getText();  // prendre el valeur min champ recherche
                    fp = f.GetFichesParNomPatient(nom_patien);
         
                       
                return fp;
            }
        };
        task.setOnSucceeded(e -> {   
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         Nom_Maladie.setCellValueFactory(new PropertyValueFactory<>("maldaie"));
                                                    medicaments.setCellValueFactory(new PropertyValueFactory<>("traitement"));
         descr.setCellValueFactory(new PropertyValueFactory<>("Diagnostique"));
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
          id_fiche.setCellValueFactory(new PropertyValueFactory<>("id_fiche"));
          
                                        tableView.setItems(null);
                                        tableView.setItems(data); 
                 tableView.setItems(FXCollections.observableArrayList(task.getValue()));
        
        }
        );
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
           
//Pour user d'Id =1 
//                  Services_Patient cp = new Services_Patient();
//      Patient p = cp.recherchePatient(1);
                   String nom_patien = tf1.getText(); 
            ObservableList<FichePatient> sk = FXCollections.observableArrayList(f.ArrayChercherFiche1(Integer.valueOf(tf1.getText())));
            data = FXCollections.observableArrayList();
        ArrayList<FichePatient> ls = f.ArrayChercherFiche1(Integer.valueOf(tf1.getText()));
        
        ls.stream().forEach((j)->{
            
      
            data.add(j);
        });
        
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         Nom_Maladie.setCellValueFactory(new PropertyValueFactory<>("maldaie"));
                                                    medicaments.setCellValueFactory(new PropertyValueFactory<>("traitement"));
         descr.setCellValueFactory(new PropertyValueFactory<>("Diagnostique"));
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
          id_fiche.setCellValueFactory(new PropertyValueFactory<>("id_fiche"));
          
                                        tableView.setItems(null);
                                        tableView.setItems(data);           
                                        prog.setVisible(false);
                                           }
        });
        Thread th = new Thread(task);
        th.start();
    }

    @FXML
    private void mouseClickedss(MouseEvent event) {
    }

    @FXML
    private void OnKeyReleased(KeyEvent event) {
        afficherMat1();
        tableView.getItems().clear();
    }
              
   
}



 