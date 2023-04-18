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

/*
Recommendation: This part just includes a demo interface of recommending. I planned to use OpenAI' API to generate movie recommendation
information. However, Due to the situation that realtime responses require much JSON knowledge and stable api, which
is completely out of my current ability. Here's the chatting part I kept which will only show the same information with the users' input.
 */
public class recommendGPTController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private JFXTextArea infoInputText;

    @FXML
    private VBox msgBox;

    //onAction on buttons to send messages while calling "addMsg" generating new boxes.
    public void sendMsg(){
        String text = infoInputText.getText();
        if( text == null || text.trim().equals("")){
            return;
        }
        //set the input empty again.
        infoInputText.setText("");
        addMsg(text, true);
        addMsg(text, false);
    }

    //generate new chat boxes according to the pages' FXML property and judge whether the message is from users or not
    private void addMsg(String msg, boolean judgeUser){
       //set the property with the pages' FXML property. All the data are from set property.
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

    //switch to commonUser interfaces.
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
