package com.example.moviemanagement.utils;

import java.sql.*;

public class inputUtils {
    public String registerRepiCheck(String username, String password, String realname, String telNumber){
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
    return "aaa";
    }

}
