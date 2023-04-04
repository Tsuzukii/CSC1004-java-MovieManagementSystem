package com.example.moviemanagement;

import com.example.moviemanagement.utils.JdbcUtils;
import com.example.moviemanagement.utils.inputUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class registerController {
    @FXML
    private Button trueRegister;

    @FXML
    private TextField usernameFieldRegister;

    @FXML
    private PasswordField passwordFieldRegister;

    @FXML
    private TextField addressRegister;

    @FXML
    private TextField ageRegister;

    @FXML
    private Button myBack;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchTo(String sce) throws IOException{
        root = FXMLLoader.load(getClass().getResource(sce));
        stage = (Stage)(scene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching");
    }

    public void switchToLogin(ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Switching to Login");
    }

    public void setMyRegister() throws SQLException, IOException {

        scene = usernameFieldRegister.getScene();
        scene = passwordFieldRegister.getScene();
        scene = addressRegister.getScene();
        scene = ageRegister.getScene();


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

        inputUtils myInput = new inputUtils();
        int maxlength = 60;
        String errorinfo = "null";
        myInput.registerationRepititionCheck(usernameFieldRegister.getText(), passwordFieldRegister.getText(), addressRegister.getText(), ageRegister.getText(), errorinfo);
        if (usernameFieldRegister.getLength() > maxlength){
            errorinfo = "username too long";
        }
        else if (passwordFieldRegister.getLength() > maxlength) {
            errorinfo = "password too long";
        }
        else if (addressRegister.getLength() > maxlength) {
            errorinfo = "real name too long";
        }
        else if(ageRegister.getLength() > maxlength) {
            errorinfo = "tel number too long";
        }
        else if(usernameFieldRegister.getText().equals(null)||passwordFieldRegister.getText().equals("")||addressRegister.getText().equals("")||ageRegister.getText().equals("")){
            errorinfo = "input information is null";
        }
        //查重
        switch (errorinfo)
        {
            case "null" :
                JdbcUtils tmp = new JdbcUtils();
                List<Object> registerInfo = new ArrayList<>();
                registerInfo.add(usernameFieldRegister.getText());
                registerInfo.add(passwordFieldRegister.getText());
                registerInfo.add(addressRegister.getText());
                registerInfo.add(ageRegister.getText());
                //scene = usernameFieldRegister.getScene();
                String sql = "insert into `user`(username, password, realName, age) " +
                        "values(?, ?, ?, ?)";
                String returnTest = "null";
                tmp.updateDBWithStatement(sql, registerInfo, returnTest);
                if (returnTest.equals("success")){
                    System.out.println("register success");
                }
                break;

            case "username too long":
                switchTo("registerError.fxml");
                System.out.println("1");
                break;

            case "password too long":
                switchTo("registerError.fxml");
                System.out.println("2");
                break;

            case "real name too long":
                switchTo("registerError.fxml");
                System.out.println("3");
                break;

            case "tel number too long":
                switchTo("registerError.fxml");
                System.out.println("4");
                break;

            case "Registration repetition":
                switchTo("registerError.fxml");
                System.out.println("5");
        }

    }
}

