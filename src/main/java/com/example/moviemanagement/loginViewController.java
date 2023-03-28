package com.example.moviemanagement;

import com.example.moviemanagement.utils.JdbcUtils;
import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.*;
import com.jfoenix.controls.JFXCheckBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class loginViewController {
    private PreparedStatement myPrepared;
    String mysqlurl = "jdbc:mysql://localhost:3306/MovieManagementSystem";
    Connection myConnectionLogin = DriverManager.getConnection(mysqlurl, "root", "18721376230");
    private ResultSet resultSet;
    private ResultSet myResult;
    //JavaFX variables
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private JFXCheckBox adminCheckbox;

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
    private TextField ageRegister;



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

    public void switchToLogin(ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Login");
    }

    public loginViewController() throws SQLException {
    }



    public void switchTo(String sce) throws IOException{
        root = FXMLLoader.load(getClass().getResource(sce));
        stage = (Stage)(scene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Register");
    }


    public void tryLogin() throws Exception {
        try {
            JdbcUtils tmp = new JdbcUtils();
            tmp.databaseDriverConnection();
            String sql = "select";
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("SQLException");
            throw new RuntimeException(e);
        }

        scene = usernameField.getScene();
        String inputUsn = usernameField.getText();
        String inputPwd = passwordField.getText();
        if (adminCheckbox.isSelected()) {
            String sql = "select * from `admin` where username = ? and password = ?";
            List<Object> myQuestion = new ArrayList<>();
            myQuestion.add(inputUsn);
            myQuestion.add(inputPwd);
            myPrepared = myConnectionLogin.prepareStatement(sql);
            myPrepared.setObject(1, myQuestion.get(0));
            myPrepared.setObject(2, myQuestion.get(1));
            resultSet = myPrepared.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int counter = 0;
            int col = metaData.getColumnCount();
            while (resultSet.next()) {
                counter++;
                System.out.println("ID: " + resultSet.getInt("id"));
            }
            if (counter == 0) {
                //error page and return to former login page
                System.out.println("Either password or username is incorrect.");
            } else {
                switchTo("adminUserView.fxml");
                stage.setTitle("MovieManagementSystem_admin");
            }

        }
        else{
            String sql = "select * from `user` where username = ? and password = ?";
            List<Object> myQuestion = new ArrayList<>();
            myQuestion.add(inputUsn);
            myQuestion.add(inputPwd);
            myPrepared = myConnectionLogin.prepareStatement(sql);
            myPrepared.setObject(1, myQuestion.get(0));
            myPrepared.setObject(2, myQuestion.get(1));
            resultSet = myPrepared.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int counter = 0;
            int col = metaData.getColumnCount();
            while (resultSet.next()) {
                counter++;
                System.out.println("ID: " + resultSet.getInt("id"));
            }
            if (counter == 0) {
                System.out.println("Either password or username is incorrect.");
            } else {
                switchTo("newCommonUser.fxml");
                stage.setTitle("MovieManagementSystem_user");
            }

        }

    }
    public void setMyRegister() throws SQLException {
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

        int maxlength = 60;
        String errorinfo = null;
        if (usernameFieldRegister.getLength() > maxlength){
            errorinfo = "username too long";
        }
        else if (passwordFieldRegister.getLength() > maxlength) {
            errorinfo = "password too long";
        }
        else if (realNameRegister.getLength() > maxlength) {
            errorinfo = "real name too long";
        }
        else if(ageRegister.getLength() > maxlength) {
            errorinfo = "tel number too long";
        }
        //查重

        switch (errorinfo)
        {
            case "null" :
                //查重判断还没写 写在inputUtils
                JdbcUtils tmp = new JdbcUtils();
                List<Object> registerInfo = new ArrayList<>();
                registerInfo.add(usernameFieldRegister.getText());
                registerInfo.add(passwordFieldRegister.getText());
                registerInfo.add(realNameRegister.getText());
                registerInfo.add(ageRegister.getText());
                //scene = usernameFieldRegister.getScene();
                String sql = "insert into `user`(username, password, realName, age) " +
                        "values(?, ?, ?, ?)";
                String returnTest = "null";
                tmp.updateDBWithStatement(sql, registerInfo, returnTest);
                if (returnTest.equals("success")){
                    System.out.println("register success");
            }


            case "username too long":

            case "password too long":

            case "real name too long":

            case "tel number too long":
        }


    }

}