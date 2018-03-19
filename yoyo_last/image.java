<<<<<<< HEAD
=======

>>>>>>> d4de6be042c65dd18dbd181f87aafa4e5bfba4ad
package com.codesmuggler5.socialpro.controllers;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import com.codesmuggler5.socialpro.gui.stages.MemberStage;
import com.codesmuggler5.socialpro.models.SkillUser;
import com.codesmuggler5.socialpro.services.impl.SkillUserService;
import com.codesmuggler5.socialpro.services.impl.UserService;
import com.codesmuggler5.socialpro.technique.ConnectedUser;
import com.github.sarxos.webcam.Webcam;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;
import javax.imageio.ImageIO;

public class ProfileController implements Initializable{

	@FXML private Label username;
	@FXML private Label name;
	@FXML private Label phone;
	@FXML private Label work;
	@FXML private Label email;
	@FXML private Label intro;
	@FXML private ImageView profileImg;
	@FXML private Pane skillpane;
	private Window chooserWindow;
	private String url = "http://localhost:2017/SocialPro/web/resources/avatars/";
	FileChooser changeImg;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		update();

	}

	public void update(){
		username.setText(ConnectedUser.getInstance().getUsername());
		name.setText(ConnectedUser.getInstance().getFirstName()+" "+ConnectedUser.getInstance().getLastName());
		phone.setText(ConnectedUser.getInstance().getPhone());
		work.setText(ConnectedUser.getInstance().getWork());
		email.setText(ConnectedUser.getInstance().getEmail());
		intro.setText(ConnectedUser.getInstance().getIntro());
		intro.setMaxWidth(300);
		intro.setWrapText(true);
		profileImg.setImage(new Image(url+ConnectedUser.getInstance().getProfileImg()));
		profileImg.setFitWidth(140);
		profileImg.setFitHeight(130);
		addSkillsBar();

	}

	@FXML public void onEditProfileAction(){
		MemberStage.getInstance().changeView(MemberStage.getInstance().getEditProfileView());
	}

	@FXML
	public void changeProfileImg() throws IOException{
		changeImg = new FileChooser();
		changeImg.setTitle("badel taswira");
		changeImg.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		File selectedFile = changeImg.showOpenDialog(chooserWindow);
		if (selectedFile != null) {
			try {
				File dest = new File("C:\\wamp64\\www\\SocialPro\\web\\resources\\avatars\\"+selectedFile.getName());
				Files.copy(selectedFile.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
				UserService us = new UserService();
				us.changeUserImg(ConnectedUser.getInstance().getId(), selectedFile.getName());
				ConnectedUser.getInstance().setProfileImg(selectedFile.getName());
				profileImg.setImage(new Image(url+ConnectedUser.getInstance().getProfileImg()));
	        } catch (IOException ex) {
	        	System.err.println(ex);
	        }
		 }
	}

        @FXML public void captureProfileImg()
        {
            Webcam webcam = Webcam.getDefault();
            webcam.open();
            try
            {
                ImageIO.write(webcam.getImage(), "PNG", new File("C:\\wamp64\\www\\SocialPro\\web\\resources\\avatars\\ProfileImg.png"));
                UserService us = new UserService();
                us.changeUserImg(ConnectedUser.getInstance().getId(), "ProfileImg.png");
                ConnectedUser.getInstance().setProfileImg("ProfileImg.png");
                profileImg.setImage(new Image(url+ConnectedUser.getInstance().getProfileImg()));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

	public void addSkillsBar(){
		int y = 1;
		SkillUserService sus = new SkillUserService();
		skillpane.getChildren().clear();
		for(SkillUser su : sus.getUserSkills(ConnectedUser.getInstance().getId()))
		{
			if(su.getLevel()>0){
				Label l = new Label();
				ProgressBar pb = new ProgressBar();
				pb.setProgress((double)su.getLevel()/(double)100);
				pb.setLayoutY(y*40);
				pb.setPrefWidth(150);
				l.setText(su.getSkill().getType());
				l.setLayoutY(y*40-20);
				skillpane.getChildren().add(pb);
				skillpane.getChildren().add(l);
				y++;
			}
		}

	}


}
<<<<<<< HEAD
=======


>>>>>>> d4de6be042c65dd18dbd181f87aafa4e5bfba4ad
