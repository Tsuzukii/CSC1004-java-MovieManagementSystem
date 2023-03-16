package com.example.moviemanagement;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("MovieManagementSystem");
        stage.setScene(scene);
        stage.show();
    }




}