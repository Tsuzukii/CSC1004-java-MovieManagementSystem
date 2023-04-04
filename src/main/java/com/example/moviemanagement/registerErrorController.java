package com.example.moviemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class registerErrorController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTMyRegister(ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("registerView.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Register");
    }
}
