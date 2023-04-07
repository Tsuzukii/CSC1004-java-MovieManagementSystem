package com.example.moviemanagement;

import com.example.moviemanagement.models.commonUser;
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



    public loginViewController() throws SQLException {
    }

    //switch to certain scenes
    public void switchTo(String sce) throws IOException{
        scene = usernameField.getScene();
        root = FXMLLoader.load(getClass().getResource(sce));
        //scene = usernameField.getScene();
        stage = (Stage)(scene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Register");
    }

    //dealing with login, differentiating normal users and admins.
    public void tryLogin() throws Exception {
        //connect with DB driver
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

        //admin user Login function, constructing query form, looking up certain information in DB
        if (adminCheckbox.isSelected()) {
            String sql = "select * from `admin` where username = ? and password = ?";
            List<Object> myQuestion = new ArrayList<>();
            myQuestion.add(inputUsn);
            myQuestion.add(inputPwd);
            myPrepared = myConnectionLogin.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            myPrepared.setObject(1, myQuestion.get(0));
            myPrepared.setObject(2, myQuestion.get(1));
            resultSet = myPrepared.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int counter = 0;
            int col = metaData.getColumnCount();
            while (resultSet.next()) {
                counter ++;
                System.out.println("ID: " + resultSet.getInt("id"));
            }
            if (counter == 0) {
                //error page and return to former login page
                switchTo("loginError.fxml");
                stage.centerOnScreen();
                System.out.println("Either password or username is incorrect.");
            } else {
                resultSet.beforeFirst();
                while ((resultSet.next()) && (resultSet != null)) {
                    commonUser.setUserType("admin");
                    commonUser.setUsername(usernameField.getText());
                    commonUser.setUserid(resultSet.getInt("id"));
                }
                if (commonUser.getType().equals("admin")){
                    System.out.println("Admin Initialize successfully");
                }
                switchTo("adminUserView.fxml");
                stage.centerOnScreen();
                stage.setTitle("MovieManagementSystem_admin");
            }

        }
        else{
            String sql = "select * from `user` where username = ? and password = ?";
            List<Object> myQuestion = new ArrayList<>();
            myQuestion.add(inputUsn);
            myQuestion.add(inputPwd);
            myPrepared = myConnectionLogin.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            myPrepared.setObject(1, myQuestion.get(0));
            myPrepared.setObject(2, myQuestion.get(1));
            resultSet = myPrepared.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int counter = 0;
            int col = metaData.getColumnCount();
            while (resultSet.next()) {
                counter++;
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println(resultSet.getNString("gender"));
                System.out.println(resultSet.getNString("username"));
            }
            if (counter == 0) {
                switchTo("loginError.fxml");
                System.out.println("Either password or username is incorrect.");
                stage.setTitle("MovieManagementLoginError");
            } else {
                scene = passwordField.getScene();
                resultSet.beforeFirst();
                while ((resultSet.next()) && (resultSet != null)){
                    commonUser.setUserid(resultSet.getInt("id"));
                    commonUser.setUserType("commonUser");
                    commonUser.setGender(resultSet.getNString("gender"));
                    commonUser.setUsername(resultSet.getNString("username"));
                    commonUser.setAge(resultSet.getInt("age"));
                }
                if (commonUser.getType().equals("commonUser") && commonUser.getName().equals(usernameField.getText())){
                    System.out.println("Users Initialize successfully");
                }
                switchTo("newCommonUser.fxml");
                stage.setTitle("MovieManagementSystem_user");
            }

        }

    }


}