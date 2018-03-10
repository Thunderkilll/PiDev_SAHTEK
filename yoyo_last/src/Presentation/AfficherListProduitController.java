/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacecrudcentree;

import Entite.Produits;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import services.CrudProduits;

/**
 * FXML Controller class
 *
 * @author khaled22
 */
public class AfficherListProduitController implements Initializable {
     @FXML
    private Button delete;
    @FXML
    private TableView<Produits> tableView;
    @FXML
    private TableColumn<Produits, String > nomProd;
    @FXML
    private TableColumn<Produits, Integer> id_prod;
    @FXML
    private TableColumn<Produits, Integer> ref;
    @FXML
    private TableColumn<Produits, Double> prix;
    @FXML
    private TableColumn<Produits, String> descr;
    @FXML
   
    private Button quitterb;
    private ObservableList<Produits> data ;
     public static Produits pr=new Produits();
    @FXML
    private Button modif_btn2;
     private ArrayList<Produits>produits;
         @FXML
    private TextField texttt;
          public ProgressIndicator proog;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        CrudProduits pr1 = new CrudProduits();
        ObservableList<Produits> sk = FXCollections.observableArrayList(pr1.AfficherAll());
          data = FXCollections.observableArrayList();
        ArrayList<Produits> ls = pr1.AfficherAll();
        ls.stream().forEach((Produits j)->{
            data.add(j);
        });
        
       nomProd.setCellValueFactory(new PropertyValueFactory<>("nom"));
     id_prod.setCellValueFactory(new PropertyValueFactory<>("id"));
   ref.setCellValueFactory(new PropertyValueFactory<>("réf"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
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
     Produits tff=tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
    
  
  //  descr.setText(tff.getDescription());
});
//
  }

 @FXML
    void delete_btn2(ActionEvent event) {
         pr=tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
String n=pr.getDescription();
CrudProduits p=new CrudProduits();
p.deleteProduit(n);
 CrudProduits prr = new CrudProduits();
 ObservableList<Produits> sk = FXCollections.observableArrayList(p.AfficherAll());
            data = FXCollections.observableArrayList();
        ArrayList<Produits> lst = p.AfficherAll();
        lst.stream().forEach((Produits j)->{
            data.add(j);
        });
        
      
                                     nomProd.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                      id_prod.setCellValueFactory(new PropertyValueFactory<>("id"));
   ref.setCellValueFactory(new PropertyValueFactory<>("réf"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));

     
                                        tableView.setItems(null);
                                        tableView.setItems(data);
                                      //  setmouseclicked();
    }

/*
    
    
    recherche dinamique par rihab / khaled correction
    */
    
//    @FXML
//    private void NavigateToPage4(ActionEvent event) {
//    }
    
    
    public void afficherMat3() {

        Task<ArrayList<Produits>> task = new Task() {
            @Override
            protected Object call() {
               // Platform.runLater(() -> prog.setVisible(true));
                
                
                    produits =  new CrudProduits().afficher();
               
                return produits;
            }
        };
        task.setOnSucceeded(e -> {
      nomProd.setCellValueFactory(new PropertyValueFactory<>("nom"));
      id_prod.setCellValueFactory(new PropertyValueFactory<>("id"));
   ref.setCellValueFactory(new PropertyValueFactory<>("réf"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("descrption"));
       }
        );
        task.setOnFailed(e -> {
            System.out.println("recherche failed ");
            //Platform.runLater(() -> Platform.runLater(() -> AlertDialog.show("Erreur", "Erreur d'actualisation ", Alert.AlertType.ERROR)));
            afficherMat3();
//            prog.setVisible(false);

        });
        Thread th = new Thread(task);
        th.start();
    }
    
    
    public void afficherMat4() {

        Task<ArrayList<Produits>> task = new Task() {
            @Override
            protected Object call() {
             
                String description=texttt.getText();
                    produits =  new CrudProduits().Rechercher(description);
         
                       
                return produits;
            }
        };
        task.setOnSucceeded(e -> {
     nomProd.setCellValueFactory(new PropertyValueFactory<>("nom"));
        id_prod.setCellValueFactory(new PropertyValueFactory<>("id"));
     ref.setCellValueFactory(new PropertyValueFactory<>("réf"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("description"));
       }
        );
                  task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
             
                CrudProduits p = new CrudProduits();
                ObservableList<Produits> sk = FXCollections.observableArrayList(p.AfficherAll());
                data = FXCollections.observableArrayList();
                ArrayList<Produits> ls = p.AfficherAll();
                ls.stream().forEach((Produits j)->{
                    data.add(j);
                });
                
    
     nomProd.setCellValueFactory(new PropertyValueFactory<>("nom"));
                                    id_prod.setCellValueFactory(new PropertyValueFactory<>("id"));
   ref.setCellValueFactory(new PropertyValueFactory<>("réf"));
     prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
     descr.setCellValueFactory(new PropertyValueFactory<>("descrption"));
                tableView.setItems(null);
                tableView.setItems(data);
                proog.setVisible(false);
            }
        });
        Thread th = new Thread(task);
        th.start();
    }
    
    
    
    
      @FXML
    private void Modifier(ActionEvent event) throws IOException {
      
             pr=tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
                Parent page1 = FXMLLoader.load(getClass().getResource("ModifProduit.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            
    }

    @FXML
    private void OnKeyReleased(KeyEvent event) {
         
        tableView.getItems().clear();
         afficherMat4();
    }

    @FXML
    private void NavigateToAcceuil(ActionEvent event) {
        
          try {
                   
                Parent page1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
               
                
                Stage S = new Stage();
                Scene scene = new Scene(page1);
                S.setScene(scene);
                S.show();

                 Stage S2 = (Stage) retour.getScene().getWindow();
                S2.close();
                
               
        } catch (Exception e) {
              System.out.println("error in the return \n"+e);
        }
    }

    @FXML
    private void NavigateToPage4(ActionEvent event) {
    }
   
}
    

