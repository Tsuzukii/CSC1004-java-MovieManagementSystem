package com.example.moviemanagement;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class adminUserViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static List<String> movie = new ArrayList<>();

    public void Initialize(){
        movie.add("The Shawshank Redemption");
        movie.add("Forrest Gump");
        movie.add("Leon");
    }

    public void switchToLogin (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to CommonUser");
    }




}
