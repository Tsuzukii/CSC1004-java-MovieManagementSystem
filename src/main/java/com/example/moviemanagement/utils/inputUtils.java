package com.example.moviemanagement.utils;

import com.example.moviemanagement.loginViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class inputUtils {

    private PreparedStatement myPrepared;
    String mysqlurl = "jdbc:mysql://localhost:3306/MovieManagementSystem";
    Connection myConnectionLogin = DriverManager.getConnection(mysqlurl, "root", "18721376230");
    private ResultSet resultSet;
    private ResultSet myResult;

    public inputUtils() throws SQLException {
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTo(String sce) throws IOException{
        System.out.println(this.getClass().getResource("/com/example/moviemanagement/"+sce));
        root = FXMLLoader.load(this.getClass().getResource("/com/example/moviemanagement/"+sce));
        stage = (Stage)(scene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Register");
    }

    //check whether the user has already existed in the database while registering,
    public void registerationRepititionCheck(String username, String pwd, String address, String age, String gender, String errorinfo) throws SQLException, IOException {
        try {
            JdbcUtils tmp = new JdbcUtils();
            tmp.databaseDriverConnection();
            //String sql = "select";
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("SQLException");
            throw new RuntimeException(e);
        }
        String sql = "select * from `user` where username = ? and password = ? and address = ? and age = ? and gender = ?";
        List<Object> registerInfo = new ArrayList<>();
        registerInfo.add(username);
        registerInfo.add(pwd);
        registerInfo.add(address);
        registerInfo.add(age);
        registerInfo.add(gender);
        myPrepared = myConnectionLogin.prepareStatement(sql);
        myPrepared.setObject(1, registerInfo.get(0));
        myPrepared.setObject(2, registerInfo.get(1));
        myPrepared.setObject(3, registerInfo.get(2));
        myPrepared.setObject(4, registerInfo.get(3));
        myPrepared.setObject(5, registerInfo.get(4));
        resultSet = myPrepared.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int counter = 0;
        int col = metaData.getColumnCount();
        loginViewController tmp = new loginViewController();
        while (resultSet.next()) {
            counter++;
            System.out.println("ID: " + resultSet.getInt("id"));
        }
        if (counter == 0) {
            //switchTo("registerError.fxml");
            errorinfo = "null";
            System.out.println("Registration success");
        } else {
            errorinfo = "registerRepetition";
        }
    }

}
