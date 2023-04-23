package com.example.moviemanagement;

import com.example.moviemanagement.utils.JdbcUtils;
import com.jfoenix.controls.JFXButton;
import com.leewyatt.rxcontrols.controls.RXFillButton;
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
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
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
    @FXML
    private TextArea filePathTextArea;
    @FXML
    private RXFillButton browseFileEdit;
    @FXML
    private Label editPicLabel;
    public List<String> movieEdit = new ArrayList<>();

    private FileChooser fileChooser;
    private File file;
    private FileInputStream fileInputStream;

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
    :params deleteMovie: specific movie names to be deleted.
    :params movieEdit： edited movie names' List.
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
            scene = addConfirm.getScene();
            switchTo("editMovie.fxml");
        }
    }

    /*
     get the added movie names from the text-field and add these name to the movie names arraylist. Then get the last movie
     name from the arraylist and assign them into the specific names so that users can comment.
     :params rp(): specific names of modified movie names.
     :params sql: updated statement with sql.
     :params currentAdd: the List to save current added movies.
     :file, fileInputStream, fileChooser: used to upload the picture to the database.
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
        String rp4 = "addedmovie4";
        String rp5 = "addedmovie5";
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
            if(file != null){
                fileInputStream = new FileInputStream(file);
            }
            if(fileInputStream != null){
                System.out.println("fis");
                currentAdd.add(fileInputStream);
                String sqlFis = "insert into `movieName`(movieName, image) " + "values(?, ?)";
                String returnTestFis = "null";
                returnTestFis = tmp.updateDBWithStatement(sqlFis, currentAdd, returnTestFis);
                if (returnTestFis.equals("success")) {
                    System.out.println("register success");
                }
            } else {
                String returnTest = "null";
                String sql = "insert into `movieName`(movieName) " + "values(?)";
                returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
                if (returnTest.equals("success")) {
                    System.out.println("add success");
                    scene = addConfirm.getScene();
                    scene = addExitButton.getScene();
                    switchTo("editMovie.fxml");
                }
            }
        }
        else if(count == 1){
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp2);
            currentAdd.add(rp2);
            if(file != null){
                fileInputStream = new FileInputStream(file);
            }
            if(fileInputStream != null){
                System.out.println("fis");
                currentAdd.add(fileInputStream);
                String sqlFis = "insert into `movieName`(movieName, image) " + "values(?, ?)";
                String returnTestFis = "null";
                returnTestFis = tmp.updateDBWithStatement(sqlFis, currentAdd, returnTestFis);
                if (returnTestFis.equals("success")) {
                    System.out.println("register success");
                }
            } else {
                String returnTest = "null";
                String sql = "insert into `movieName`(movieName) " + "values(?)";
                returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
                if (returnTest.equals("success")) {
                    System.out.println("add success");
                    scene = addConfirm.getScene();
                    scene = addExitButton.getScene();
                    switchTo("editMovie.fxml");
                }
                System.out.println(count);
                count = count + 1;
            }
        }
        else if(count == 2) {
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp3);
            currentAdd.add(rp3);
            if (file != null) {
                fileInputStream = new FileInputStream(file);
            }
            if (fileInputStream != null) {
                System.out.println("fis");
                currentAdd.add(fileInputStream);
                String sqlFis = "insert into `movieName`(movieName, image) " + "values(?, ?)";
                String returnTestFis = "null";
                returnTestFis = tmp.updateDBWithStatement(sqlFis, currentAdd, returnTestFis);
                if (returnTestFis.equals("success")) {
                    System.out.println("register success");
                }
            } else {
                String returnTest = "null";
                String sql = "insert into `movieName`(movieName) " + "values(?)";
                returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
                if (returnTest.equals("success")) {
                    System.out.println("add success");
                    scene = addConfirm.getScene();
                    scene = addExitButton.getScene();
                    switchTo("editMovie.fxml");
                }
                count = count + 1;
            }
        }
        else if(count == 3) {
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp4);
            currentAdd.add(rp4);
            if (file != null) {
                fileInputStream = new FileInputStream(file);
            }
            if (fileInputStream != null) {
                System.out.println("fis");
                currentAdd.add(fileInputStream);
                String sqlFis = "insert into `movieName`(movieName, image) " + "values(?, ?)";
                String returnTestFis = "null";
                returnTestFis = tmp.updateDBWithStatement(sqlFis, currentAdd, returnTestFis);
                if (returnTestFis.equals("success")) {
                    System.out.println("register success");
                }
            } else {
                String returnTest = "null";
                String sql = "insert into `movieName`(movieName) " + "values(?)";
                returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
                if (returnTest.equals("success")) {
                    System.out.println("add success");
                    scene = addConfirm.getScene();
                    scene = addExitButton.getScene();
                    switchTo("editMovie.fxml");
                }
                count = count + 1;
            }
        }
        else if(count == 4) {
            JdbcUtils tmp = new JdbcUtils();
            List<Object> currentAdd = new ArrayList<>();
            movieEdit.set(currentLength - 1, rp5);
            currentAdd.add(rp5);
            if (file != null) {
                fileInputStream = new FileInputStream(file);
            }
            if (fileInputStream != null) {
                System.out.println("fis");
                currentAdd.add(fileInputStream);
                String sqlFis = "insert into `movieName`(movieName, image) " + "values(?, ?)";
                String returnTestFis = "null";
                returnTestFis = tmp.updateDBWithStatement(sqlFis, currentAdd, returnTestFis);
                if (returnTestFis.equals("success")) {
                    System.out.println("register success");
                }
            } else {
                String returnTest = "null";
                String sql = "insert into `movieName`(movieName) " + "values(?)";
                returnTest = tmp.updateDBWithStatement(sql, currentAdd, returnTest);
                if (returnTest.equals("success")) {
                    System.out.println("add success");
                    scene = addConfirm.getScene();
                    scene = addExitButton.getScene();
                    switchTo("editMovie.fxml");
                }
                count = count + 1;
            }
        }
    }

    /*
    switch to Admin user pages.
     */
    public void switchToAdminMain (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("editMovie.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to adminMain");
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
            filePathTextArea.setText(file.getAbsolutePath());
            editPicLabel.setText("The picture you uploaded has been recorded. Please press confirm to insert into the system.");
        }
    }

    //initialize using the adminUserViewController's functions
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
