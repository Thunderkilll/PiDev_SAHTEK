/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Offres;
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
import services.CrudOffres;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class AfficherListOffreController implements Initializable {
    @FXML
    private Button delete;
    @FXML
    private TableView<Offres> tableOffres;
    @FXML
    private TableColumn<Offres, String> nom;
    @FXML
    private TableColumn<Offres, Date> dd;
    @FXML
    private TableColumn<Offres, Date> df;
    @FXML
    private TableColumn<Offres, String> prix;
    @FXML
    private TableColumn<Offres, String> descr;
    @FXML
    private Button quitterb;
     private ObservableList<Offres> data ;
    public static Offres of=new Offres();
    @FXML
    private Button modif_btn;
    @FXML
    private TextField txt;
 private ArrayList<Offres>offre;
    public ProgressIndicator prog;
    
    public static Offres tf;//
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          CrudOffres o = new CrudOffres();
                

        ObservableList<Offres> sk = FXCollections.observableArrayList(o.AfficherAll());
            data = FXCollections.observableArrayList();
        ArrayList<Offres> ls = o.AfficherAll();
        ls.stream().forEach((Offres j)->{
            data.add(j);
        });
        
       nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     dd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
   df.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableOffres.setItems(null);
                                        tableOffres.setItems(data);
                                       setmouseclicked();
                                     
       // nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        //descr.setCellValueFactory(new PropertyValueFactory<>("description"));
    
                                 
                                 

   

       
        
       
    
    } 
    
 
    
    
    @FXML
    void mouseClicked(MouseEvent event) {

    }
 
   private void setmouseclicked(){
tableOffres.setOnMouseClicked((MouseEvent event) -> {
    tf=tableOffres.getItems().get(tableOffres.getSelectionModel().getSelectedIndex());
    System.out.println(tf.toString());
//    nom.setText(tf.getNom());
//    dd.setText(tf.getDate_debut().toString());
//    prix.setText(tf.getPrix());
    
});


   }

 @FXML
    void delete_btn(ActionEvent event) {
String n=nom.getText();
CrudOffres c=new CrudOffres();
c.deleteOffre(n);
 CrudOffres o = new CrudOffres();
 ObservableList<Offres> sk = FXCollections.observableArrayList(o.AfficherAll());
            data = FXCollections.observableArrayList();
        ArrayList<Offres> ls = o.AfficherAll();
        ls.stream().forEach((Offres j)->{
            data.add(j);
        });        

       nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     dd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
   df.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableOffres.setItems(null);
                                        tableOffres.setItems(data);

    }

    @FXML
    private void NavigateToPage4(ActionEvent event) {
    try {
                AnchorPane test = FXMLLoader.load(getClass().getResource("interface4.fxml"));
                
                Stage S = new Stage();
                Scene scene = new Scene(test);
                S.setScene(scene);
                S.show();
                  
                Stage S2 = (Stage) quitterb.getScene().getWindow();
                S2.close();
                
                //button1.getParent()
            } catch (IOException ex) {
               
            } 
    }
    public void afficherMat() {

        Task<ArrayList<Offres>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                
                    offre =  new CrudOffres().afficher();
               
                return offre;
            }
        };
        task.setOnSucceeded(e -> {
 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     dd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
   df.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

          //  prog.setVisible(false);

        }
        );
        task.setOnFailed(e -> {
            //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
            afficherMat();
//            prog.setVisible(false);

        });
        Thread th = new Thread(task);
        th.start();
    }

  public void afficherMat1() {

        Task<ArrayList<Offres>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                String description=txt.getText();
                    offre =  new CrudOffres().Rechercher(description);
         
                       
                return offre;
            }
        };
        task.setOnSucceeded(e -> {

   nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                     dd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
   df.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

   
tableOffres.setItems(FXCollections.observableArrayList(task.getValue()));
            
          //prog.setVisible(false);

        }
        );
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
                //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
                CrudOffres o = new CrudOffres();
                ObservableList<Offres> sk = FXCollections.observableArrayList(o.AfficherAll());
                data = FXCollections.observableArrayList();
                ArrayList<Offres> ls = o.AfficherAll();
                ls.stream().forEach((Offres j)->{
                    data.add(j);
                });
                
                nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                dd.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
                df.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
                prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                descr.setCellValueFactory(new PropertyValueFactory<>("description"));
                
                
                tableOffres.setItems(null);
                tableOffres.setItems(data);
                prog.setVisible(false);
            }
        });
        Thread th = new Thread(task);
        th.start();
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
      
             of=tableOffres.getItems().get(tableOffres.getSelectionModel().getSelectedIndex());
                Parent page1 = FXMLLoader.load(getClass().getResource("ModifierOffre.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            
    }

    @FXML
    private void OnKeyReleased(KeyEvent event) {
        afficherMat1();
        tableOffres.getItems().clear();
    }

    
   
    
    
   }