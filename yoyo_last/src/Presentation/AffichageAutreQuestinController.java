/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import com.jfoenix.controls.JFXDialogLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samie
 */
public class AffichageAutreQuestinController implements Initializable {
    @FXML
    private Label id_article;
    @FXML
    private Label titre;
    @FXML
    private Label sub_t;
    @FXML
    private ImageView imgQuestion;
    @FXML
    private Button repondre;
    @FXML
    private JFXDialogLayout reponces;
    @FXML
    private Label descript;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ReurnAction(ActionEvent event) {
         try {
        Parent p1 = FXMLLoader.load(getClass().getResource("Articles.fxml"));
        Scene scene = new Scene(p1);
        Stage sageMode = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sageMode.setScene(scene);
        sageMode.show();
        } catch (IOException ex) {
            System.out.println("IoExcepion in return Articles");
        }
    }
    
}
