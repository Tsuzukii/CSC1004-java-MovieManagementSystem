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
    private BarChart<?, ?> barChartBrokeback;
    @FXML
    private BarChart<?, ?> barChartLeon;
    @FXML
    private BarChart<?, ?> barChartForrest;
    @FXML
    private AnchorPane main_form;
    @FXML
    private PieChart pieChartShawshank;
    @FXML
    private PieChart pieChartLeon;
    @FXML
    private PieChart pieChartBrokeback;
    @FXML
    private PieChart pieChartForrest;
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

    /*
    initialize the BarChart
    :params barchart: selected barchart to be initialized
    :params sql: updated sql statement
     */
    public void setBarChart(BarChart<?, ?> barChart, String sql) throws SQLException {
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
        barChart.getData().add(chartDataShawshank);
        }

    /*
    initialize the PieChart, constructing query form, update to the database
    :params piechart: selected piechart to be initialized
    :params sql: updated sql statement
     */
    public void setPieChart(String sql, PieChart pieChart) throws SQLException {
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
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
        while (i < length){
            String str=metaData.getColumnName(i);
            System.out.println(str);
            System.out.println( resultSet.getInt(i + 1));
            pieChartData.add(new PieChart.Data(metaData.getColumnName(i), resultSet.getInt(i)));
            i++;
        }

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," Number: ", data.pieValueProperty()
                        )
                ));
        pieChart.getData().addAll(pieChartData);
    }

    //initialize function and set the sql statement
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sql5 ="SELECT\n" +
                "\tCOUNT(CASE WHEN rating<=10 AND age>=10 Then 1 END) as `10`,\n" +
                "\tCOUNT(CASE WHEN rating<=9 AND age>=9 THEN 1 END) as `9`,\n" +
                "\tCOUNT(CASE WHEN rating<=8 AND age>=8 THEN 1 END) as `8`,\n" +
                "\tCOUNT(CASE WHEN rating<=7 AND age>=7 THEN 1 END) as `7`,\n" +
                "\tCOUNT(CASE WHEN rating<=6 AND age>=6 THEN 1 END) as `6`,\n" +
                "\tCOUNT(CASE WHEN rating<=5 AND age>=5 THEN 1 END) as `5`,\n" +
                "\tCOUNT(CASE WHEN rating<=4 AND age>=4 THEN 1 END) as `4`,\n" +
                "\tCOUNT(CASE WHEN rating<=3 AND age>=3 THEN 1 END) as `3`,\n" +
                "\tCOUNT(CASE WHEN rating<=2 AND age>=2 THEN 1 END) as `2`,\n" +
                "\tCOUNT(CASE WHEN rating<=1 AND age>=1 THEN 1 END) as `1`\n" +
                "FROM `The Shawshank Redemption`;\n" +
                "\n";
        String sql6 ="SELECT\n" +
                "\tCOUNT(CASE WHEN rating<=10 AND age>=10 Then 1 END) as `10`,\n" +
                "\tCOUNT(CASE WHEN rating<=9 AND age>=9 THEN 1 END) as `9`,\n" +
                "\tCOUNT(CASE WHEN rating<=8 AND age>=8 THEN 1 END) as `8`,\n" +
                "\tCOUNT(CASE WHEN rating<=7 AND age>=7 THEN 1 END) as `7`,\n" +
                "\tCOUNT(CASE WHEN rating<=6 AND age>=6 THEN 1 END) as `6`,\n" +
                "\tCOUNT(CASE WHEN rating<=5 AND age>=5 THEN 1 END) as `5`,\n" +
                "\tCOUNT(CASE WHEN rating<=4 AND age>=4 THEN 1 END) as `4`,\n" +
                "\tCOUNT(CASE WHEN rating<=3 AND age>=3 THEN 1 END) as `3`,\n" +
                "\tCOUNT(CASE WHEN rating<=2 AND age>=2 THEN 1 END) as `2`,\n" +
                "\tCOUNT(CASE WHEN rating<=1 AND age>=1 THEN 1 END) as `1`\n" +
                "FROM `Leon`;\n" +
                "\n";
        String sql7 ="SELECT\n" +
                "\tCOUNT(CASE WHEN rating<=10 AND age>=10 Then 1 END) as `10`,\n" +
                "\tCOUNT(CASE WHEN rating<=9 AND age>=9 THEN 1 END) as `9`,\n" +
                "\tCOUNT(CASE WHEN rating<=8 AND age>=8 THEN 1 END) as `8`,\n" +
                "\tCOUNT(CASE WHEN rating<=7 AND age>=7 THEN 1 END) as `7`,\n" +
                "\tCOUNT(CASE WHEN rating<=6 AND age>=6 THEN 1 END) as `6`,\n" +
                "\tCOUNT(CASE WHEN rating<=5 AND age>=5 THEN 1 END) as `5`,\n" +
                "\tCOUNT(CASE WHEN rating<=4 AND age>=4 THEN 1 END) as `4`,\n" +
                "\tCOUNT(CASE WHEN rating<=3 AND age>=3 THEN 1 END) as `3`,\n" +
                "\tCOUNT(CASE WHEN rating<=2 AND age>=2 THEN 1 END) as `2`,\n" +
                "\tCOUNT(CASE WHEN rating<=1 AND age>=1 THEN 1 END) as `1`\n" +
                "FROM `Forrest Gump`;\n" +
                "\n";
        String sql8 ="SELECT\n" +
                "\tCOUNT(CASE WHEN rating<=10 AND age>=10 Then 1 END) as `10`,\n" +
                "\tCOUNT(CASE WHEN rating<=9 AND age>=9 THEN 1 END) as `9`,\n" +
                "\tCOUNT(CASE WHEN rating<=8 AND age>=8 THEN 1 END) as `8`,\n" +
                "\tCOUNT(CASE WHEN rating<=7 AND age>=7 THEN 1 END) as `7`,\n" +
                "\tCOUNT(CASE WHEN rating<=6 AND age>=6 THEN 1 END) as `6`,\n" +
                "\tCOUNT(CASE WHEN rating<=5 AND age>=5 THEN 1 END) as `5`,\n" +
                "\tCOUNT(CASE WHEN rating<=4 AND age>=4 THEN 1 END) as `4`,\n" +
                "\tCOUNT(CASE WHEN rating<=3 AND age>=3 THEN 1 END) as `3`,\n" +
                "\tCOUNT(CASE WHEN rating<=2 AND age>=2 THEN 1 END) as `2`,\n" +
                "\tCOUNT(CASE WHEN rating<=1 AND age>=1 THEN 1 END) as `1`\n" +
                "FROM `Brokeback Mountain`;\n" +
                "\n";
        try {
            setPieChart(sql5, pieChartShawshank);
            setPieChart(sql6, pieChartLeon);
            setPieChart(sql7, pieChartForrest);
            setPieChart(sql8, pieChartBrokeback);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql1 ="SELECT\n" +
                "\tCOUNT(CASE WHEN age<=18 AND age>=0 Then 1 END) as `0-18`,\n" +
                "\tCOUNT(CASE WHEN age<=40 AND age>=19 THEN 1 END) as `19-40`,\n" +
                "\tCOUNT(CASE WHEN age<=60 AND age>=41 THEN 1 END) as `41-60`,\n" +
                "\tCOUNT(CASE WHEN age<=100 AND age>=61 THEN 1 END) as `61-100`\n" +
                "FROM `The Shawshank Redemption`;\n" +
                "\n";
        String sql2 ="SELECT\n" +
                "\tCOUNT(CASE WHEN age<=18 AND age>=0 Then 1 END) as `0-18`,\n" +
                "\tCOUNT(CASE WHEN age<=40 AND age>=19 THEN 1 END) as `19-40`,\n" +
                "\tCOUNT(CASE WHEN age<=60 AND age>=41 THEN 1 END) as `41-60`,\n" +
                "\tCOUNT(CASE WHEN age<=100 AND age>=61 THEN 1 END) as `61-100`\n" +
                "FROM `Leon`;\n" +
                "\n";
        String sql3 ="SELECT\n" +
                "\tCOUNT(CASE WHEN age<=18 AND age>=0 Then 1 END) as `0-18`,\n" +
                "\tCOUNT(CASE WHEN age<=40 AND age>=19 THEN 1 END) as `19-40`,\n" +
                "\tCOUNT(CASE WHEN age<=60 AND age>=41 THEN 1 END) as `41-60`,\n" +
                "\tCOUNT(CASE WHEN age<=100 AND age>=61 THEN 1 END) as `61-100`\n" +
                "FROM `Brokeback Mountain`;\n" +
                "\n";
        String sql4 ="SELECT\n" +
                "\tCOUNT(CASE WHEN age<=18 AND age>=0 Then 1 END) as `0-18`,\n" +
                "\tCOUNT(CASE WHEN age<=40 AND age>=19 THEN 1 END) as `19-40`,\n" +
                "\tCOUNT(CASE WHEN age<=60 AND age>=41 THEN 1 END) as `41-60`,\n" +
                "\tCOUNT(CASE WHEN age<=100 AND age>=61 THEN 1 END) as `61-100`\n" +
                "FROM `Forrest Gump`;\n" +
                "\n";
        try {
            setBarChart(barChartShawshank, sql1);
            setBarChart(barChartLeon, sql2);
            setBarChart(barChartBrokeback, sql3);
            setBarChart(barChartForrest, sql4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
