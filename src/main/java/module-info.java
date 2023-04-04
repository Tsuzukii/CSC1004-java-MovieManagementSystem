module com.example.moviemanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires mysql.connector.j;
    //requires rxcontrols;


    opens com.example.moviemanagement to javafx.fxml;
    exports com.example.moviemanagement;
    opens com.example.moviemanagement.utils to javafx.fxml;
    //exports com.example.moviemanagement.controllers;
    //opens com.example.moviemanagement.controllers to javafx.fxml;
    //exports com.example.moviemanagement.controllers;
    //opens com.example.moviemanagement.controllers to javafx.fxml;
}