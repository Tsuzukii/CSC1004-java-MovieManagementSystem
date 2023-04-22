package com.example.moviemanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class JdbcUtils {
    String mysqlurl = "jdbc:mysql://localhost:3306/MovieManagementSystem";
    Connection myConnection = DriverManager.getConnection(mysqlurl, "root", "18721376230");;

    public JdbcUtils() throws SQLException {
    }

    //database driver connection
    public Connection databaseDriverConnection() throws ClassNotFoundException, SQLException {
        System.out.println("Start dealing with login");
        //load mysql driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //database information
        String mysqlurl = "jdbc:mysql://localhost:3306/MovieManagementSystem";
        //connect to database
        Connection myConnection = DriverManager.getConnection(mysqlurl, "root", "18721376230");
        if (myConnection != null) {
            System.out.println("Database Connected Successfully");
        }
        return myConnection;
    }


    private PreparedStatement myPreparedState;

    /*update database with modified statement,
    :params sql: sql statement
    :params params: list that saving needed information
    :params re: returnstest to check whether updating is successful or not
     */
    public String updateDBWithStatement(String sql, List<Object> params, String re) throws SQLException {
        myPreparedState = myConnection.prepareStatement(sql);
        boolean paramsResult = false;

        if (params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                if ( params.get(i)!= null && !params.isEmpty()){
                    paramsResult = true;
                }
            }
        }

        if (paramsResult){
            for (int i = 0; i < params.size(); i++){
                myPreparedState.setObject(i+1, params.get(i));
            }
        }
        int resultNumber = -1;
        resultNumber = myPreparedState.executeUpdate();
        System.out.println(resultNumber);
        if (resultNumber != -1){
            re = "success";
        }
        return re;
    }








}
