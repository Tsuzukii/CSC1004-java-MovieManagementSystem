module com.example.moviemanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.moviemanagement to javafx.fxml;
    exports com.example.moviemanagement;
}