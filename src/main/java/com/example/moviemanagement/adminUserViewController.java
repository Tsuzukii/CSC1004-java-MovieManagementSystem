package com.example.moviemanagement;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class adminUserViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static List<String> movie = new ArrayList<>();

    public void Initialize(){
        movie.add("The Shawshank Redemption");
        movie.add("Forrest Gump");
        movie.add("Leon");
    }




}
