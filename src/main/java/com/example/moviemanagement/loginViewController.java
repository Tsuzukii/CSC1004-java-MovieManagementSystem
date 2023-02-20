package com.example.moviemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;

public class loginViewController {
    //JavaFX variables
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox myCheckbox;

    @FXML
    private Button myRegister;

    @FXML
    private Button myLogin;

    @FXML
    private Button trueRegister;

    @FXML
    private TextField usernameFieldRegister;

    @FXML
    private PasswordField passwordFieldRegister;

    @FXML
    private TextField realNameRegister;

    @FXML
    private TextField telNumberRegister;




    private Stage stage;
    private Scene scene;
    private Parent root;

    //switch scenes from login page to register scene when clicking the "register" button
    public void switchToRegister(ActionEvent register) throws IOException{
        root = FXMLLoader.load(getClass().getResource("registerView.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Register");
    }

    //switch scenes from register page to login scene when clicking the "back" button
    public void switchToLogin(ActionEvent register) throws IOException{
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Login");
    }

    //deal with login verification
    private void loginVerification() throws ClassNotFoundException, SQLException {
        System.out.println("Start dealing with login");
        //load mysql driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //database information
        String mysqlurl = "jdbc:mysql://localhost:3306/MovieManagementSystem";
        //connect to database
        Connection myConnection = DriverManager.getConnection(mysqlurl, "root", "18721376230");
        if (myConnection != null) {
            System.out.println("Database Connected Successfully");
        }


    }

}