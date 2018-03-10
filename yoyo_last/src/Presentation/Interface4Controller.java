/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Centre;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.CrudCentre;
import services.CrudOffres;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Interface4Controller implements Initializable {
    private Button  quitterb;
    @FXML
    private TableColumn<Centre, String> nom_centre;
    @FXML
    private TableColumn<Centre, Integer> id_centre;
    @FXML
    private TableColumn<Centre, String> adresse;
    @FXML
    private TableColumn<Centre, Integer> tel;
    @FXML
    private TableColumn<Centre, String> descr;
     private ObservableList<Centre> data ;
     
    @FXML  private TableView<Centre> tableView;
       public static Centre cen=new Centre();
       private ArrayList<Centre>centre;
    @FXML  private TextField txtt;
            public ProgressIndicator progg;
//    @FXML
//    private AnchorPane delete;
     public static Centre cee=new Centre();
//      @FXML
//    private AnchorPane delete;
    @FXML
    private AnchorPane delete;
    @FXML
    private Button bt2;
    @FXML
    private Button btoffre;
    @FXML
    private Button btproduit;
    
   
       
    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        CrudCentre c = new CrudCentre();
                

        ObservableList<Centre> sk = FXCollections.observableArrayList(c.AfficherAll());//lis tout les centres
            data = FXCollections.observableArrayList();
        ArrayList<Centre> ls = c.AfficherAll();
        ls.stream().forEach((j)->{
            data.add(j);
        });
        
       nom_centre.setCellValueFactory(new PropertyValueFactory<>("nom"));
      id_centre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
  adresse.setCellValueFactory(new PropertyValueFactory<>("addresse"));
     tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableView.setItems(null);
                                        tableView.setItems(data);

                                         setmouseclicked();
         }  
    
    
    
    
    
    
    
    
@FXML
      void mouseClicked(MouseEvent event) {

    }
     
 
   private void setmouseclicked(){
tableView.setOnMouseClicked((MouseEvent event) -> {
 // @Override
  // public void handle(MouseEvent event) {
        Centre tft=tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
        
        nom_centre.setText(tft.getNom());
      descr.setText(tft.getDescription());
      adresse.setText(tft.getAddresse());
      id_centre.setText(tft.getId_centre()+"");
      tel.setText(tft.getTelephone()+"");

    //}
});


   }
   
   
   
   
   
   
   
    

    public void afficherMat1() {

        Task<ArrayList<Centre>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                
                    centre =  new CrudCentre().afficher();
               
                return centre;
            }
        };
        task.setOnSucceeded(e -> {
    
       nom_centre.setCellValueFactory(new PropertyValueFactory<>("nom"));
      id_centre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
  adresse.setCellValueFactory(new PropertyValueFactory<>("addresse"));
     tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableView.setItems(null);
                                        tableView.setItems(data);

     tableView.setItems(FXCollections.observableArrayList(task.getValue()));
                                         }
        );
        task.setOnFailed(e -> {
            //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
            afficherMat1();
//            prog.setVisible(false);

        });
        Thread thh = new Thread(task);
        thh.start();
    }
     public void afficherMat12() {

        Task<ArrayList<Centre>> task = new Task() {
            @Override
            protected Object call() {
              
                
                String description=txtt.getText();
                    centre =  new CrudCentre().Rechercher(description);
         
                       
                return centre;
            }
        };
        task.setOnSucceeded(e -> {
          
       nom_centre.setCellValueFactory(new PropertyValueFactory<>("nom"));
      id_centre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
  adresse.setCellValueFactory(new PropertyValueFactory<>("addresse"));
     tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableView.setItems(null);
                                        tableView.setItems(data);

            tableView.setItems(FXCollections.observableArrayList(task.getValue()));                            
        
        }
        );
 task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
                //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
                CrudCentre c = new CrudCentre();
                ObservableList<Centre> sk = FXCollections.observableArrayList(c.AfficherAll());
                data = FXCollections.observableArrayList();
                ArrayList<Centre> ls = c.AfficherAll();
                ls.stream().forEach((Centre j)->{
                    data.add(j);
                });
                    
       nom_centre.setCellValueFactory(new PropertyValueFactory<>("nom"));
      id_centre.setCellValueFactory(new PropertyValueFactory<>("id_centre"));
  adresse.setCellValueFactory(new PropertyValueFactory<>("addresse"));
     tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableView.setItems(null);
                                        tableView.setItems(data);

                                        progg.setVisible(false);}
        
         });
        Thread thh = new Thread(task);
        thh.start();
    }

  
@FXML
    void OnKeyReleased(KeyEvent event) {
          afficherMat12();
        tableView.getItems().clear();

    }


    @FXML
    private void delete_btn1(MouseEvent event) {
    }

    @FXML
    private void RetourAction(ActionEvent event) {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("Acceil.fxml"));
        Scene scene = new Scene(p);
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    
        } catch (Exception e) {
            System.out.println("error in retour "+e);
        }
  }

    @FXML
    private void listOffres(ActionEvent event) {
          try {
            Parent p = FXMLLoader.load(getClass().getResource("AfficherListOffre.fxml"));
        Scene scene = new Scene(p);
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    
        } catch (Exception e) {
            System.out.println("error in retour "+e);
        }
        
    }

    @FXML
    private void listProduits(ActionEvent event) {//AfficherListProduit
          try {
            Parent p = FXMLLoader.load(getClass().getResource("AfficherListProduit.fxml"));
        Scene scene = new Scene(p);
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    
        } catch (Exception e) {
            System.out.println("error in retour "+e);
        }
    }

   
} 
    
    

