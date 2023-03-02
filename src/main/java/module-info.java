module com.example.moviemanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires mysql.connector.j;


    opens com.example.moviemanagement to javafx.fxml;
    exports com.example.moviemanagement;
}