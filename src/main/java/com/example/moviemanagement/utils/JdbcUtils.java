package com.example.moviemanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
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



}
