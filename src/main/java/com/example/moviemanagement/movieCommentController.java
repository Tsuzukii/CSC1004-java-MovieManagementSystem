package com.example.moviemanagement;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class movieCommentController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea commentTextArea;

    @FXML
    private JFXButton myConfirm;

    @FXML
    private JFXButton myExit;


    public void switchToMain(ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newCommonUser.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Login");
    }
}
