package com.example.moviemanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class JdbcUtils {
    private Connection myConnection;


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
    public String updateDBWithStatement(String sql, List<Object> params, String re) throws SQLException {
        String result = "error";
        myPreparedState = myConnection.prepareStatement(sql);
        boolean paramsResult = false;
        if (params.size() > 0){
            for (int i = 0; i < params.size(); i++){
                if ( params.get(i)!= null ){
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
        if (resultNumber != -1){
            result = "success";
            re = "success";
        }
        return result;
    }



}
