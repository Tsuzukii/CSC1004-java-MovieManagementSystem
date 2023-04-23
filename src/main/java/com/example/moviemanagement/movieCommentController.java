package com.example.moviemanagement;


import com.example.moviemanagement.models.commonUser;
import com.example.moviemanagement.utils.JdbcUtils;
import com.example.moviemanagement.utils.inputUtils;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
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

    @FXML
    private JFXButton buttonBrowse;

    @FXML
    private Label uploadLabel;

    @FXML
    private TextArea commentPicPath;

    private FileChooser fileChooser;
    private File file;
    private FileInputStream fileInputStream;

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

    public void switchTo(String sce) throws IOException{
        root = FXMLLoader.load(getClass().getResource(sce));
        stage = (Stage)(scene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching");
    }

    //using the function to get current login user so that the user's information can be saved into the database
    public void initializeCommentInfo(List<Object> info) throws IOException {
        String commentUsn = commonUser.getName();
        int commentAge = commonUser.getAge();
        if (ratingChoiceBox == null || ratingChoiceBox.getValue() == null) {
            System.out.println("error");
            scene = ratingChoiceBox.getScene();
            switchTo("newCommonUser.fxml");
        } else {
            int rating = (int) ratingChoiceBox.getValue();
            info.add(commentUsn);
            info.add(commentTextArea.getText());
            info.add(commentAge);
            info.add(rating);
        }
    }

    /*
    save the comment to the database with updated list information, switch cases to match current movies to comment
    :params commentMovie: the selected movie to be commented

     */
    public void commentDealing() throws SQLException, IOException, NullPointerException {
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
        //判空
        if(commentMovie == null || ratingChoiceBox == null || ratingChoiceBox.getValue() == null){
            System.out.println("commentMovie null, commenting again.");
            scene = ratingChoiceBox.getScene();
            switchTo("newCommonUser.fxml");
        }
        else {
            switch (commentMovie) {
                case "The Shawshank Redemption":
                    List<Object> shawshankMovieInfo = new ArrayList<>();
                    initializeCommentInfo(shawshankMovieInfo);
                    System.out.println(shawshankMovieInfo + "fffffff");
                    String sql = "insert into `The Shawshank Redemption`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        shawshankMovieInfo.add((InputStream) fileInputStream);
                        System.out.println(shawshankMovieInfo);
                        String sql2 = "insert into `The Shawshank Redemption`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTest = "null";
                        returnTest = tmp.updateDBWithStatement(sql2, shawshankMovieInfo, returnTest);
                        if (returnTest.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTest = "null";
                        returnTest = tmp.updateDBWithStatement(sql, shawshankMovieInfo, returnTest);
                        if (returnTest.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "Forrest Gump":
                    List<Object> ForrestMovieInfo = new ArrayList<>();
                    initializeCommentInfo(ForrestMovieInfo);
                    String sqlForrest = "insert into `Forrest Gump`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        ForrestMovieInfo.add((InputStream) fileInputStream);
                        System.out.println(ForrestMovieInfo);
                        String sqlForrest2 = "insert into `Forrest Gump`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestForrest2 = "null";
                        returnTestForrest2 = tmp.updateDBWithStatement(sqlForrest2, ForrestMovieInfo, returnTestForrest2);
                        if (returnTestForrest2.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestForrest = "null";
                        returnTestForrest = tmp.updateDBWithStatement(sqlForrest, ForrestMovieInfo, returnTestForrest);
                        if (returnTestForrest.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "Brokeback Mountain":
                    List<Object> BrokebackMovieInfo = new ArrayList<>();
                    initializeCommentInfo(BrokebackMovieInfo);
                    String sqlBrokeback = "insert into `Brokeback Mountain`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        BrokebackMovieInfo.add((InputStream) fileInputStream);
                        System.out.println(BrokebackMovieInfo);
                        String sqlBrokeback2 = "insert into `Brokeback Mountain`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTest = "null";
                        returnTest = tmp.updateDBWithStatement(sqlBrokeback2, BrokebackMovieInfo, returnTest);
                        if (returnTest.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestBrokeback = "null";
                        returnTestBrokeback = tmp.updateDBWithStatement(sqlBrokeback, BrokebackMovieInfo, returnTestBrokeback);
                        if (returnTestBrokeback.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "Leon":
                    List<Object> LeonMovieInfo = new ArrayList<>();
                    initializeCommentInfo(LeonMovieInfo);
                    String sqlLeon = "insert into `Leon`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";;
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        LeonMovieInfo.add((InputStream) fileInputStream);
                        System.out.println(LeonMovieInfo);
                        String sqlLeon2 = "insert into `Leon`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestLeon2 = "null";
                        returnTestLeon2 = tmp.updateDBWithStatement(sqlLeon2, LeonMovieInfo, returnTestLeon2);
                        if (returnTestLeon2.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestLeon = "null";
                        returnTestLeon = tmp.updateDBWithStatement(sqlLeon, LeonMovieInfo, returnTestLeon);
                        if (returnTestLeon.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "addedmovie1":
                    List<Object> addMovieInfo1 = new ArrayList<>();
                    initializeCommentInfo(addMovieInfo1);
                    String sqladd1 = "insert into `addedmovie1`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        addMovieInfo1.add((InputStream) fileInputStream);
                        System.out.println(addMovieInfo1);
                        String sqlLeon2 = "insert into `addedmovie1`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestAdded2 = "null";
                        returnTestAdded2 = tmp.updateDBWithStatement(sqlLeon2, addMovieInfo1, returnTestAdded2);
                        if (returnTestAdded2.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestadd1 = "null";
                        returnTestadd1 = tmp.updateDBWithStatement(sqladd1, addMovieInfo1, returnTestadd1);
                        if (returnTestadd1.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "addedmovie2":
                    List<Object> addMovieInfo2 = new ArrayList<>();
                    initializeCommentInfo(addMovieInfo2);
                    String sqladd2 = "insert into `addedmovie2`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        addMovieInfo2.add((InputStream) fileInputStream);
                        System.out.println(addMovieInfo2);
                        String sqlLeon2 = "insert into `addedmovie2`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestAdded3 = "null";
                        returnTestAdded3 = tmp.updateDBWithStatement(sqlLeon2, addMovieInfo2, returnTestAdded3);
                        if (returnTestAdded3.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestadd2 = "null";
                        returnTestadd2 = tmp.updateDBWithStatement(sqladd2, addMovieInfo2, returnTestadd2);
                        if (returnTestadd2.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "addedmovie3":
                    List<Object> addMovieInfo3 = new ArrayList<>();
                    initializeCommentInfo(addMovieInfo3);
                    String sqladd3 = "insert into `addedmovie3`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        addMovieInfo3.add((InputStream) fileInputStream);
                        System.out.println(addMovieInfo3);
                        String sqlLeon2 = "insert into `addedmovie3`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestAdded4 = "null";
                        returnTestAdded4 = tmp.updateDBWithStatement(sqlLeon2, addMovieInfo3, returnTestAdded4);
                        if (returnTestAdded4.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestadd3 = "null";
                        returnTestadd3 = tmp.updateDBWithStatement(sqladd3, addMovieInfo3, returnTestadd3);
                        if (returnTestadd3.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "addedmovie4":
                    List<Object> addMovieInfo4 = new ArrayList<>();
                    initializeCommentInfo(addMovieInfo4);
                    String sqlAdd4 = "insert into `addedmovie4`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        addMovieInfo4.add((InputStream) fileInputStream);
                        System.out.println(addMovieInfo4);
                        String sqlAdded4 = "insert into `addedmovie4`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestAdded5 = "null";
                        returnTestAdded5 = tmp.updateDBWithStatement(sqlAdded4, addMovieInfo4, returnTestAdded5);
                        if (returnTestAdded5.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestadd4 = "null";
                        returnTestadd4 = tmp.updateDBWithStatement(sqlAdd4, addMovieInfo4, returnTestadd4);
                        if (returnTestadd4.equals("success")) {
                            System.out.println("register success");
                        }
                    }
                    break;
                case "addedmovie5":
                    List<Object> addMovieInfo5 = new ArrayList<>();
                    initializeCommentInfo(addMovieInfo5);
                    String sqlAdd5 = "insert into `addedmovie5`(username, comments, age, rating) " +
                            "values(?, ?, ?, ?)";
                    if (file != null){
                        fileInputStream = new FileInputStream(file);
                    }
                    if (fileInputStream != null) {
                        System.out.println("666");
                        addMovieInfo5.add((InputStream) fileInputStream);
                        System.out.println(addMovieInfo5);
                        String sqlLeon2 = "insert into `addedmovie5`(username, comments, age, rating, image) " +
                                "values(?, ?, ?, ?, ?)";
                        String returnTestAdded6 = "null";
                        returnTestAdded6 = tmp.updateDBWithStatement(sqlLeon2, addMovieInfo5, returnTestAdded6);
                        if (returnTestAdded6.equals("success")) {
                            System.out.println("register success");
                        }
                    } else {
                        String returnTestadd5 = "null";
                        returnTestadd5 = tmp.updateDBWithStatement(sqlAdd5, addMovieInfo5, returnTestadd5);
                        if (returnTestadd5.equals("success")) {
                            System.out.println("register success");
                        }
                    }
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

    public void ChooseFile(ActionEvent choose) throws Exception{
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG =
                new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG", "*.jpg",
                        "*.JPEG", "*.jpeg");
        fileChooser.getExtensionFilters().addAll(extFilterJPG);
        file = fileChooser.showOpenDialog(stage);
        if (file != null){
            System.out.println(1);
            commentPicPath.setText(file.getAbsolutePath());
            uploadLabel.setText("The picture you uploaded has been recorded. Please press confirm to insert into the system.");
        }
    }

}
