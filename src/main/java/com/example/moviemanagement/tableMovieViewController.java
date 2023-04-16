package com.example.moviemanagement;

import com.example.moviemanagement.models.movies;
import com.example.moviemanagement.utils.JdbcUtils;
import com.leewyatt.rxcontrols.controls.RXFillButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class tableMovieViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private PreparedStatement myPrepared;
    String mysqlurl = "jdbc:mysql://localhost:3306/MovieManagementSystem";
    Connection myConnection = DriverManager.getConnection(mysqlurl, "root", "18721376230");
    private ResultSet resultSet;

    @FXML
    private TableColumn<movies, String> colMovieN;

    @FXML
    private TableColumn<movies, String> colRate;

    @FXML
    private TableColumn<movies, String> colUsn;

    @FXML
    private TableColumn<movies, Integer> coliD;

    @FXML
    private RXFillButton tableBackMain;

    @FXML
    private TableView<movies> rateTable;

    private ObservableList<movies> movieList;

    public tableMovieViewController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sql = "SELECT * FROM `The Shawshank Redemption`";
        String sql2 = "SELECT * FROM `Leon`";
        //String sql3 = "SELECT * FROM `Brokeback Mountain`";
        String sql4 = "SELECT * FROM `Forrest Gump`";
        try {
            activateTable(sql);
            activateTable(sql2);
            //activateTable(sql3);
            //activateTable(sql4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void activateTable(String sql) throws SQLException {
        //connect with DB driver
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

        movieList = FXCollections.observableArrayList();
        resultSet = myConnection.createStatement().executeQuery(sql);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String tableName = resultSetMetaData.getTableName(1);
        while (resultSet.next()){
            movies rateMovies = new movies(resultSet.getInt("id"), resultSet.getString("rating"), resultSet.getString("username"), tableName);
            rateMovies.setId(resultSet.getInt("id"));
            rateMovies.setRates(resultSet.getString("rating"));
            rateMovies.setUsername(resultSet.getString("username"));
            rateMovies.setMoviename(tableName);
            movieList.add(rateMovies);
        }
        coliD.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMovieN.setCellValueFactory(new PropertyValueFactory<>("moviename"));
        colRate.setCellValueFactory(new PropertyValueFactory<>("rates"));
        colUsn.setCellValueFactory(new PropertyValueFactory<>("username"));
        rateTable.setItems(movieList);
    }

    public void switchToAdmin (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adminUserView.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Table");
    }


}

