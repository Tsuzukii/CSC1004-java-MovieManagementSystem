package com.example.moviemanagement;

import com.example.moviemanagement.utils.JdbcUtils;
import com.leewyatt.rxcontrols.controls.RXFillButton;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class moviePlotsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private BarChart<?, ?> barChartShawshank;
    @FXML
    private AnchorPane main_form;
    @FXML
    private PieChart pieChartShawshank;
    @FXML
    private RXFillButton plotsReturn;
    private PreparedStatement myPreparedStatement;
    private ResultSet resultSet;
    String url = "jdbc:mysql://localhost:3306/MovieManagementSystem";
    Connection myConnection = DriverManager.getConnection(url, "root", "18721376230");

    public moviePlotsController() throws SQLException {
    }

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

    public void setBarChartShawshank() throws SQLException {
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
        String sql ="SELECT\n" +
                "\tCOUNT(CASE WHEN age<=18 AND age>=0 Then 1 END) as `0-18`,\n" +
                "\tCOUNT(CASE WHEN age<=40 AND age>=19 THEN 1 END) as `19-40`,\n" +
                "\tCOUNT(CASE WHEN age<=60 AND age>=41 THEN 1 END) as `41-60`,\n" +
                "\tCOUNT(CASE WHEN age<=100 AND age>=61 THEN 1 END) as `61-100`\n" +
                "FROM `The Shawshank Redemption`;\n" +
                "\n";
        myPreparedStatement = myConnection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        resultSet = myPreparedStatement.executeQuery();
        XYChart.Series chartDataShawshank = new XYChart.Series();
        resultSet.last();
        int length = resultSet.getMetaData().getColumnCount();
        resultSet.first();
        System.out.println(length+"fff");
        int i = 1;
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (i < length){
            String str=metaData.getColumnName(i);
            System.out.println(str);
            System.out.println( resultSet.getInt(i + 1));
            chartDataShawshank.getData().add(new XYChart.Data<>(metaData.getColumnName(i), resultSet.getInt(i)));
            i++;
            }
        barChartShawshank.getData().add(chartDataShawshank);
        }

    public void setPieChartShawshank() throws SQLException {
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
        String sql ="SELECT\n" +
                "\tCOUNT(CASE WHEN rating<=10 AND age>=10 Then 1 END) as `10`,\n" +
                "\tCOUNT(CASE WHEN age<=40 AND age>=19 THEN 1 END) as `19-40`,\n" +
                "\tCOUNT(CASE WHEN age<=60 AND age>=41 THEN 1 END) as `41-60`,\n" +
                "\tCOUNT(CASE WHEN age<=100 AND age>=61 THEN 1 END) as `61-100`\n" +
                "FROM `The Shawshank Redemption`;\n" +
                "\n";
        myPreparedStatement = myConnection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        resultSet = myPreparedStatement.executeQuery();
        resultSet.last();
        int length = resultSet.getMetaData().getColumnCount();
        resultSet.first();
        System.out.println(length+"fff");
        int i = 1;
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(resultSet.getInt(1));
        System.out.println(resultSet.getInt(2));
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data(metaData.getColumnName(1), resultSet.getInt(1)),
                        new PieChart.Data("9", 30)
                );

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," Number: ", data.pieValueProperty()
                        )
                ));
        pieChartShawshank.getData().addAll(pieChartData);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setPieChartShawshank();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            setBarChartShawshank();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
