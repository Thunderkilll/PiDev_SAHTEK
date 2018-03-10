/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation;

import Entite.Articles;
import Entite.Patient;
import Entite.Users;
import Services.Csv;
import Services.Services_Patient;
import Services.ServicesArticle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class ArticlesController implements Initializable {
    @FXML
    private TableView<Articles> tableb;
    @FXML
    private TableColumn<Articles,Integer> id;
    @FXML
    private TableColumn<Articles, String> titre;
    @FXML
    private TableColumn<Articles, String>  Sub_t;
    @FXML
    private TableColumn<Articles, String>  descr;
    @FXML
    private TableColumn<Articles, String>  image;
    @FXML
    private TextField id_article;
    @FXML
    private Button bt8;
    @FXML
    private Button bt7;
    @FXML
    private Button bt9;
     private ArrayList<Articles>Articl;
    /**/
     private ObservableList<Articles> data ; 
    @FXML
    private Button afficher;
      public ProgressIndicator prog;
    @FXML
    private Button bt1;

    public TextField getId_article() {
        return id_article;
    }

    public void setId_article(TextField id_article) {
        this.id_article = id_article;
    }
   
     ServicesArticle sr = new ServicesArticle();
  
    
     Services_Patient cp = new Services_Patient();
                            Users p1 = cp.recherchePatient(1);


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              Services.ServicesArticle sf = new ServicesArticle();
//Pour user d'Id =1 
                  Services_Patient cp = new Services_Patient();
      Patient p = cp.recherchePatient(1);
   
        ObservableList<Articles> sk = FXCollections.observableArrayList( sf.afficheArticle(p.getId_usr()));
            data = FXCollections.observableArrayList();
        ArrayList<Articles> ls = sf.afficheArticle(p.getId_usr());
        
        ls.stream().forEach((j)->{
            
            
            data.add(j);
        });
        
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
                                     titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         Sub_t.setCellValueFactory(new PropertyValueFactory<>("sub_t"));
                                                   
         descr.setCellValueFactory(new PropertyValueFactory<>("descript"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
                                        tableb.setItems(null);
                                        tableb.setItems(data);
    }    


    @FXML
    private void ModifierArticleRedirection(ActionEvent event) {
          try {
              
           FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../Presentation/ModifierArticle.fxml"));
        Parent p3;
        
                    p3 = fxmlLoader.load();
          Articles ps1 =tableb.getSelectionModel().getSelectedItem();
              Scene s3 = new Scene(p3);
              Presentation.ModifierArticleController mc = (Presentation.ModifierArticleController) fxmlLoader.getController();
                    
                      Articles ps = sr.rechercheArticle(ps1.getId());
                
                 mc.getTitre().setText(ps.getTitre());
                mc.getSub_t().setText(ps.getSub_t());
                  mc.getDescript().setText(ps.getDescript());
                  mc.getImage().setText(ps.getImage());
                  mc.getId().setText(ps.getId()+"");
             
             
         
           
                    
                 
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
    private void AjoutArticleRedirection(ActionEvent event) {
         try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("AjouterQuestion.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) bt7.getScene().getWindow();
                S2.close();
                
            
            } catch (IOException ex) {
               // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(" \nerror here is \n"+ex);
            }
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
            System.out.println("vraiment choqué minik \n"+ex);
        }
    }

    @FXML
    private void AfficherAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();  
          fxmlLoader.setLocation(getClass().getResource("AffichageQuestion.fxml"));
            Parent p3;
        try {
            p3 = fxmlLoader.load();
               Articles ps1 =tableb.getSelectionModel().getSelectedItem();
          AffichageQuestionController af = (AffichageQuestionController)  fxmlLoader.getController();       
         Scene s3 = new Scene(p3);
          af.getId_article().setText(ps1.getId()+"");
           af.getTitre().setText(ps1.getTitre());
           af.getSub_t().setText(ps1.getSub_t());
           af.getDescript().setText(ps1.getDescript());
           File file = new File(Services_Patient.ImageConverter(ps1.getImage()));
            Image image = new Image(file.toURI().toString());
           af.getImgQuestion().setImage(image);
         
          Stage App = (Stage) ((Node) event.getSource()).getScene().getWindow();
        App.setScene(s3);
        App.show();
         
         
        } catch (IOException ex) {
            Logger.getLogger(ArticlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        
    }

    @FXML
    private void excel(ActionEvent event) {
            Services.ServicesArticle sf = new ServicesArticle();
//Pour user d'Id =1 
                  Services_Patient cp = new Services_Patient();
      Patient p = cp.recherchePatient(1);
   
        ObservableList<Articles> sk = FXCollections.observableArrayList( sf.afficheArticle(p.getId_usr()));
            data = FXCollections.observableArrayList();
        ArrayList<Articles> ls = sf.afficheArticle(p.getId_usr());
        
        ls.stream().forEach((j)->{
            
            
            data.add(j);
        });
        
             Csv csv=new Csv(data);
    }
    
    public void afficherMat() {

        Task<ArrayList<Articles>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                
                    Articl  = sr.afficher();//a creer
               
                return Articl;
            }
        };
        task.setOnSucceeded(e -> {
          id.setCellValueFactory(new PropertyValueFactory<>("id"));
           titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         Sub_t.setCellValueFactory(new PropertyValueFactory<>("sub_t"));
         descr.setCellValueFactory(new PropertyValueFactory<>("descript"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
                                        tableb.setItems(null);
                                        tableb.setItems(data);
                                      //  tableb.setItems(FXCollections.observableArrayList(task.getValue()));
        }
                 );
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
                //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
               ServicesArticle ar = new ServicesArticle();
                ObservableList<Articles> sk = FXCollections.observableArrayList(ar.AfficherAll());
                data = FXCollections.observableArrayList();
                ArrayList<Articles> ls = ar.AfficherAll();
                ls.stream().forEach((Articles j)->{
                    data.add(j);
                });
                   id.setCellValueFactory(new PropertyValueFactory<>("id"));
                                     titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         Sub_t.setCellValueFactory(new PropertyValueFactory<>("sub_t"));
                                                   
         descr.setCellValueFactory(new PropertyValueFactory<>("descript"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
                                        tableb.setItems(null);
                                        tableb.setItems(data);
                                         prog.setVisible(false);
            }
        });
        Thread th = new Thread(task);
        th.start();
    }
    
 public void afficherMat1() {

        Task<ArrayList<Articles>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                    String id_articles = id_article.getText();  // prendre el valeur min champ recherche
                    Articl =  new ServicesArticle().Rechercher(id_articles);
         
                       
                return Articl;
            }
        };
        task.setOnSucceeded(e -> {   
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
          titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         Sub_t.setCellValueFactory(new PropertyValueFactory<>("sub_t"));
                                                   
         descr.setCellValueFactory(new PropertyValueFactory<>("descript"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
                                        tableb.setItems(null);
                                        tableb.setItems(data);
         
                 tableb.setItems(FXCollections.observableArrayList(task.getValue()));
        
        }
        );
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
            Services.ServicesArticle sf = new ServicesArticle();
//Pour user d'Id =1 
                  Services_Patient cp = new Services_Patient();
      Patient p = cp.recherchePatient(1);
   
        ObservableList<Articles> sk = FXCollections.observableArrayList( sf.afficheArticle(p.getId_usr()));
            data = FXCollections.observableArrayList();
        ArrayList<Articles> ls = sf.afficheArticle(p.getId_usr());
        
        ls.stream().forEach((j)->{
            
            System.out.println(j.getId()+"fita3bya mata3 ell lise");
            data.add(j);
        });
        
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
                                     titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
         Sub_t.setCellValueFactory(new PropertyValueFactory<>("sub_t"));
                                                   
         descr.setCellValueFactory(new PropertyValueFactory<>("descript"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
        
                                        tableb.setItems(null);
                                        tableb.setItems(data);
                                        prog.setVisible(false);
                                           }
        });
        Thread th = new Thread(task);
        th.start();
    }
              
   
              @FXML
    private void OnKeyReleased(KeyEvent event) {
        afficherMat1();
        tableb.getItems().clear();
    }

    @FXML
    private void mouseClickedss(MouseEvent event) {
    }
   
  
    
}
