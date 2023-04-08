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
/*
    <AnchorPane prefHeight="472.0" prefWidth="683.0" xmlns="http://javafx.com/javafx/19" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.moviemanagement.recommendGPTController">
   <children>
      <ScrollPane layoutX="2.0" prefHeight="399.0" prefWidth="682.0">
         <content>
            <VBox fx:id="msgBox" prefHeight="396.0" prefWidth="680.0">
               <children>
                  <AnchorPane prefHeight="151.0" prefWidth="680.0">
                     <children>
                        <ImageView fitHeight="64.0" fitWidth="63.0" layoutX="570.0" layoutY="42.0" pickOnBounds="true" preserveRatio="true" />
                        <Label layoutX="181.0" layoutY="41.0" prefHeight="68.0" prefWidth="344.0" style="-fx-border-color: black;" text="Label&#10;qq&#10;" />
                     </children>
                  </AnchorPane>
                  <AnchorPane layoutX="10.0" layoutY="10.0" prefHeight="168.0" prefWidth="680.0">
                     <children>
                        <ImageView fitHeight="64.0" fitWidth="63.0" layoutX="34.0" layoutY="64.0" pickOnBounds="true" preserveRatio="true">
                           <image>
                              <Image url="@../../../images/openai.jpg" />
                           </image>
                        </ImageView>
                        <Label layoutX="129.0" layoutY="62.0" prefHeight="68.0" prefWidth="351.0" style="-fx-border-color: black;" text="Label&#10;qq&#10;" />
                     </children>
                  </AnchorPane>
               </children>
            </VBox>
         </content>
      </ScrollPane>
      <JFXTextArea fx:id="infoInputText" focusColor="#78c2c4" layoutX="125.0" layoutY="418.0" prefHeight="37.0" prefWidth="441.0" />
      <RXFillButton fx:id="myEixt" layoutX="12.0" layoutY="411.0" prefHeight="48.0" prefWidth="93.0" text="Exit">
         <font>
            <Font size="28.0" />
         </font>
      </RXFillButton>
      <RXFillButton fx:id="mySend" fillType="RIGHT_TO_LEFT" layoutX="577.0" layoutY="410.0" onAction="#sendMsg" prefHeight="48.0" prefWidth="93.0" text="Send">
         <font>
            <Font size="28.0" />
         </font>
      </RXFillButton>
   </children>
</AnchorPane>
   */
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
          //myImage.setImage(new Image("file:"));
       }
       else {
          myImage.setLayoutX(34);
          myImage.setLayoutY(64);
          myImage.setImage(new Image("file:/Users/felixyan/IdeaProjects/CSC1004-java-MovieManagementSystem2/src/main/resources/images/openai.jpg"));
       }
       Label message = new Label(msg);
       message.setStyle("-fx-border-color: black");
       message.setPrefSize(351, 68);
       message.setLayoutX(129.0);
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
