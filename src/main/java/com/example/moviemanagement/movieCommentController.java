package com.example.moviemanagement;


import com.example.moviemanagement.models.commonUser;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

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
    private Label movieLabel;

    @FXML
    private ChoiceBox ratingChoiceBox;

    public List<String> movie = new ArrayList<>();
    private Object[] ratingScore = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

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

    //using the function to get current login user so that the user's information can be saved into the database
    public void initializeCommentInfo(List<Object> info){
        String commentUsn = commonUser.getName();
        int commentAge = commonUser.getAge();
        int rating = (int) ratingChoiceBox.getValue();
        info.add(commentUsn);
        info.add(commentTextArea.getText());
        info.add(commentAge);
        info.add(rating);
    }

    /*
    save the comment to the database with updated list information
    :params commentMovie: the selected movie to be commented
    switch cases to match current movies to comment
     */
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

        String commentMovie = movieChoiceBox.getValue();
        JdbcUtils tmp = new JdbcUtils();
        System.out.println(commentMovie);

        switch (commentMovie){
            case "The Shawshank Redemption":
                List<Object> shawshankMovieInfo = new ArrayList<>();
                initializeCommentInfo(shawshankMovieInfo);
                String sql = "insert into `The Shawshank Redemption`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTest = "null";
                returnTest = tmp.updateDBWithStatement(sql, shawshankMovieInfo, returnTest);
                if (returnTest.equals("success")){
                    System.out.println("register success");
                }
                break;
            case "Forrest Gump":
                List<Object> ForrestMovieInfo = new ArrayList<>();
                initializeCommentInfo(ForrestMovieInfo);
                String sqlForrest = "insert into `Forrest Gump`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTestForrest = "null";
                returnTestForrest = tmp.updateDBWithStatement(sqlForrest, ForrestMovieInfo, returnTestForrest);
                if (returnTestForrest.equals("success")){
                    System.out.println("register success");
                }
                break;
            case "Brokeback Mountain":
                List<Object> BrokebackMovieInfo = new ArrayList<>();
                initializeCommentInfo(BrokebackMovieInfo);
                String sqlBrokeback = "insert into `Brokeback Mountain`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTestBrokeback = "null";
                returnTestBrokeback = tmp.updateDBWithStatement(sqlBrokeback, BrokebackMovieInfo, returnTestBrokeback);
                if (returnTestBrokeback.equals("success")){
                    System.out.println("register success");
                }
            case "Leon":
                List<Object> LeonMovieInfo = new ArrayList<>();
                initializeCommentInfo(LeonMovieInfo);
                String sqlLeon = "insert into `Leon`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTestLeon = "null";
                returnTestLeon = tmp.updateDBWithStatement(sqlLeon, LeonMovieInfo, returnTestLeon);
                if (returnTestLeon.equals("success")){
                    System.out.println("register success");
                }
            case "addedmovie1":
                List<Object> addMovieInfo1 = new ArrayList<>();
                initializeCommentInfo(addMovieInfo1);
                String sqladd1 = "insert into `addedmovie1`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTestadd1 = "null";
                returnTestadd1 = tmp.updateDBWithStatement(sqladd1, addMovieInfo1, returnTestadd1);
                if (returnTestadd1.equals("success")){
                    System.out.println("register success");
                }
            case "addedmovie2":
                List<Object> addMovieInfo2 = new ArrayList<>();
                initializeCommentInfo(addMovieInfo2);
                String sqladd2 = "insert into `addedmovie2`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTestadd2 = "null";
                returnTestadd2 = tmp.updateDBWithStatement(sqladd2, addMovieInfo2, returnTestadd2);
                if (returnTestadd2.equals("success")){
                    System.out.println("register success");
                }
            case "addedmovie3":
                List<Object> addMovieInfo3 = new ArrayList<>();
                initializeCommentInfo(addMovieInfo3);
                String sqladd3 = "insert into `addedmovie3`(username, comments, age, rating) " +
                        "values(?, ?, ?, ?)";
                String returnTestadd3 = "null";
                returnTestadd3 = tmp.updateDBWithStatement(sqladd3, addMovieInfo3, returnTestadd3);
                if (returnTestadd3.equals("success")){
                    System.out.println("register success");
                }
        }

    }

    /*
    set the movieLabel to be current selected movie
     */
    public void getMovieName(ActionEvent event){
        String myMovie = movieChoiceBox.getValue();
        movieLabel.setText(myMovie);
    }

    //initialize the current movielist and label
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminUserViewController adminUserViewController = null;
        try {
            adminUserViewController = new adminUserViewController();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            adminUserViewController.arrayListInitialize((ArrayList)movie);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<Object> myMovie = new ArrayList<>();
        for (int i = 0; i < movie.size(); i++){
            myMovie.add(movie.get(i));
        }

        List<String> strings = myMovie.stream()
                .map(object -> Objects.toString(object, null))
                .toList();
        int count = strings.size();
        for (int i = 0; i < count; i++){
            movieChoiceBox.getItems().add(strings.get(i).toString());
        }
        movieChoiceBox.setOnAction(this::getMovieName);
        ratingChoiceBox.getItems().addAll(ratingScore);
        System.out.println("123");
    }


}
