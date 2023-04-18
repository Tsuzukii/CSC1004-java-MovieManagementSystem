package com.example.moviemanagement;

import com.example.moviemanagement.utils.JdbcUtils;
import com.jfoenix.controls.JFXButton;
import com.leewyatt.rxcontrols.controls.RXTextField;
import com.leewyatt.rxcontrols.controls.RXTranslationButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class editMovieController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private RXTranslationButton addExitButton;
    @FXML
    private RXTranslationButton deleteExitButton;
    @FXML
    private RXTextField movieNameAdd;
    @FXML
    private Label addedMovieName;
    @FXML
    private Label selectedDelete;
    @FXML
    private ChoiceBox<String> movieNameDelete;
    @FXML
    private RXTranslationButton addConfirm;
    @FXML
    private RXTranslationButton deleteConfirm;
    @FXML
    private JFXButton successReturn;

    public List<String> movieEdit = new ArrayList<>();

    //switch to Admin user pages.
    public void switchToAdminUser (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adminUserView.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to admin");
    }

    //get the movie to be deleted in the label
    public void getDeletedMovieName(ActionEvent event){
        String deleteMovie = movieNameDelete.getValue();
        selectedDelete.setText(deleteMovie);
    }

    //switch to specific scenes with specific fxml files.
    public void switchTo(String sce) throws IOException{
        root = FXMLLoader.load(getClass().getResource(sce));
        //scene = usernameField.getScene();
        stage = (Stage)(scene.getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Register");
    }
    /*
    get the movie to be deleted from the choice box, and delete all the related from the database and movie lists using
    the sql statement and arraylist functions.
     */
    public void deleteMovie() throws SQLException, IOException {
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

        String deleteMovie = movieNameDelete.getValue();
        selectedDelete.setText(deleteMovie);
        movieEdit.remove(deleteMovie);
        String sql = "DELETE FROM `movieName` WHERE movieName = ?";
        ArrayList<Object> waitlist = new ArrayList<>();
        waitlist.add(deleteMovie);
        String returnTest = "null";
        JdbcUtils tmp = new JdbcUtils();
        returnTest = tmp.updateDBWithStatement(sql, waitlist, returnTest);
        if (returnTest.equals("success")){
            System.out.println("delete success");
            //再次从数据库中读取电影名字
            scene = successReturn.getScene();
            switchTo("editSuccess.fxml");
        }
        //scene = successReturn.getScene();
        scene = movieNameDelete.getScene();
        switchTo("editMovie.fxml");
    }

    /*

     */
    static int count = 0;
    public void addMovie() throws SQLException, IOException {
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

        String rp1 = "addedmovie1";
        String rp2 = "addedmovie2";
        String rp3 = "addedmovie3";
        String addedMovie = movieNameAdd.getText();
        movieEdit.add(addedMovie);
        int currentLength = movieEdit.size();

        if(count == 0){
            count = count + 1;
            //System.out.println("FFFFFFFFFFFFF"+count);
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp1);
            currentAdd.add(rp1);
            String returnTest = "null";
            String sql = "insert into `movieName`(movieName) " + "values(?)";
            returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
            if (returnTest.equals("success")){
                System.out.println("add success");
            }
            scene = addConfirm.getScene();
            scene = addExitButton.getScene();
            switchTo("editMovie.fxml");
        }
        else if(count == 1){
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp2);
            currentAdd.add(rp2);
            String returnTest = "null";
            String sql = "insert into `movieName`(movieName) " + "values(?)";
            returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
            if (returnTest.equals("success")){
                System.out.println("add success");
                //成功页面
            }
            System.out.println(count);
            count = count + 1;
        }
        else if(count == 2) {
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp3);
            currentAdd.add(rp3);
            String returnTest = "null";
            String sql = "insert into `movieName`(movieName) " + "values(?)";
            returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
            if (returnTest.equals("success")){
                System.out.println("add success");
                //成功页面
                scene = successReturn.getScene();
                switchTo("editSuccess.fxml");
            }
            count = count + 1;
        }
    }

    public void switchToAdminMain (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editMovie.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to adminMain");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminUserViewController adminUserViewController = null;
        try {
            adminUserViewController = new adminUserViewController();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            adminUserViewController.arrayListInitialize((ArrayList)movieEdit);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<String> myMovie = new ArrayList<>();
        for (int i = 0; i < movieEdit.size(); i++){
            myMovie.add(movieEdit.get(i));
            movieNameDelete.getItems().add(myMovie.get(i));
        }
        //movieNameDelete.getItems().addAll(String.valueOf(myMovie));
        movieNameDelete.setOnAction(this::getDeletedMovieName);
    }
}
