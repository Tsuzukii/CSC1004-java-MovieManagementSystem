package com.example.moviemanagement;


import com.example.moviemanagement.utils.JdbcUtils;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class movieCommentController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea commentTextArea;

    @FXML
    private JFXButton myConfirm;

    @FXML
    private JFXButton myExit;

    @FXML
    private ChoiceBox<String> movieChoiceBox;

    @FXML
    private TextField movieNameTextField;

    public List<String> movie = new ArrayList<>();


    //onAction. When clicking buttons, the scene would be loaded to commonUser page.
    public void switchToMain(ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newCommonUser.fxml"));
        stage = (Stage)((Node)register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Login");
    }

    public void commentDealing() throws SQLException {
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
        String commentMovie = movieNameTextField.getText();
        switch (commentMovie){
            case "The Shawshank Redemption":
                JdbcUtils tmp = new JdbcUtils();
                List<Object> movieInfo = new ArrayList<>();
                movieInfo.add(commentTextArea.getText());
                String sql = "insert into `The Shawshank Redemption`(username, comments) " +
                        "values(?, ?)";
                String returnTest = "null";
                tmp.updateDBWithStatement(sql, movieInfo, returnTest);
                if (returnTest.equals("success")){
                    System.out.println("register success");
                }
                break;

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movie.add("The Shawshank Redemption");
        movie.add("Forrest Gump");
        movie.add("Leon");
        movieChoiceBox.getItems().addAll(movie);
    }
}
