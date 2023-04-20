package com.example.moviemanagement;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class loginErrorController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private JFXButton loginErrorRetu1rn;

    //onAction. When clicking buttons, the scene would be loaded to loginView
    public void switchToLogin(ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Login");
    }
}
