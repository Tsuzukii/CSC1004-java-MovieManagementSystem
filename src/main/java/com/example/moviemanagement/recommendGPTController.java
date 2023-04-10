package com.example.moviemanagement;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class recommendGPTController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private JFXTextArea infoInputText;

    @FXML
    private VBox msgBox;

    public void sendMsg(){
        String text = infoInputText.getText();
        if( text == null || text.trim().equals("")){
            return;
        }
        infoInputText.setText("");
        addMsg(text, true);
        addMsg(text, false);
    }

    private void addMsg(String msg, boolean judgeUser){
       AnchorPane pane = new AnchorPane();
       pane.setPrefSize(683.0, 472.0);
       ImageView myImage = new ImageView();
       myImage.setFitHeight(64);
       myImage.setFitWidth(63);
       myImage.setPickOnBounds(true);
       myImage.setPreserveRatio(true);
       if (judgeUser){
          myImage.setLayoutX(570.0);
          myImage.setLayoutY(42.0);
          myImage.setImage(new Image("file:/Users/felixyan/IdeaProjects/CSC1004-java-MovieManagementSystem2/src/main/resources/images/user.png"));
       }
       else {
          myImage.setLayoutX(34);
          myImage.setLayoutY(64);
          myImage.setImage(new Image("file:/Users/felixyan/IdeaProjects/CSC1004-java-MovieManagementSystem2/src/main/resources/images/openai.jpg"));
       }
       Label message = new Label(msg);
       message.setStyle("-fx-border-color: black");
       message.setPrefSize(351, 68);
       message.setLayoutX(135.0);
       message.setLayoutY(62);
       pane.getChildren().addAll(myImage, message);
       msgBox.getChildren().add(pane);

    }

    public void switchToMain (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newCommonUser.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Main");
    }

}
