package com.example.moviemanagement;


import com.example.moviemanagement.utils.JdbcUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class adminUserViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ResultSet resultSet;
    private PreparedStatement myPrepared;

    String url = "jdbc:mysql://localhost:3306/MovieManagementSystem";
    Connection myConnection = DriverManager.getConnection(url, "root", "18721376230");

    public adminUserViewController() throws SQLException {
    }

    /*
    add the movie from the database to the arraylist. Every time when the pages are reloaded, the function will be called
    and movie list after edited will be updated.
     */
    public void arrayListInitialize(ArrayList<String> arrayList) throws SQLException {
        //connect with the DB
        try {
            JdbcUtils tmp = new JdbcUtils();
            tmp.databaseDriverConnection();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("SQLException");
            throw new RuntimeException(e);
        }

        Statement statement = null;
        String sql = "select * from `movieName` ";
        statement = (Statement) myConnection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String movie = resultSet.getString("movieName");
            arrayList.add(movie);
        }
        //for (int i = 0; i < arrayList.size(); i++){
            //System.out.println(arrayList.get(i));
        //}
        System.out.println("666");

    }

    //the following functions are switch to specific scenes.
    public void switchToLogin (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to CommonUser");
    }

    public void switchToEdit (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editMovie.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Edit");
    }

    public void switchToTable (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tableMovieView.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Table");
    }


}
