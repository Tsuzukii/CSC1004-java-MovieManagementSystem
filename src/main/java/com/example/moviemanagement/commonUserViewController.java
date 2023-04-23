package com.example.moviemanagement;


import com.leewyatt.rxcontrols.animation.carousel.*;
import com.leewyatt.rxcontrols.controls.RXCarousel;
import com.leewyatt.rxcontrols.controls.RXFillButton;
import com.leewyatt.rxcontrols.pane.RXCarouselPane;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;


public class commonUserViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private RXFillButton commentButton;

    @FXML
    private RXFillButton recommendButton;

    @FXML
    private RXFillButton exitButton;

    @FXML
    private RXCarousel movieCarousel;

    @FXML
    private RXCarousel picCarousel;

    @FXML
    private RXCarousel infoCarousel;




    //initialize the Carousel
    @FXML
    void initialize() {
        homeCarouselInitialize();
        movieInfoCarousel();
    }

    /*
    initialize the Carousel part of mainpage. The grammar of this part used the demo of RXControls for reference.
    Note that this part of the codes' grammar take the RXcontrols demo as reference and I have done some modifications.
    The following part of the Initialize function is similar.
     */
    private void homeCarouselInitialize() {
        String[] classicMovie = {"The Shawshank Redemption","Forrest Gump","Leon"};
        ArrayList<RXCarouselPane> myMovies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView movieView = new ImageView(getClass().getResource("/homeMovie/" + (i + 1 ) + ".jpeg").toExternalForm());
            Label movieLabel = new Label(classicMovie[i]);
            movieLabel.setPrefSize(250, 35);
            movieLabel.setStyle("-fx-alignment: center;-fx-background-color: transparent;-fx-text-fill: black;-fx-font-size: 20");
            StackPane stackPane = new StackPane(movieView, movieLabel);
            RXCarouselPane myMoviePane = new RXCarouselPane(stackPane);
            movieCarousel.setCarouselAnimation(new AnimAround(true));
            movieLabel.setTranslateY(215);
            Duration T = new Duration(1100);
            movieCarousel.animationTimeProperty().set(T);
            myMovies.add(myMoviePane);
        }
        movieCarousel.setPaneList(myMovies);
    }

    //onAction. When clicking buttons, the scene would be loaded to registerView
    public void switchToComment (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("movieComment.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Comment");
    }

    //onAction. When clicking buttons, the scene would be loaded to loginView
    public void switchToLogin (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to CommonUser");
    }

    /*
    initialize the Carousel part of both movie posters and information. The
    grammar of these parts used the demo of RXControls for reference.
     */
    private void movieInfoCarousel() {
        ArrayList<RXCarouselPane> moviesPics = new ArrayList<>();
        ArrayList<RXCarouselPane> moviesInfo = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ImageView movieView = new ImageView(getClass().getResource("/moviePoster/" + (i + 1 ) + ".jpeg").toExternalForm());
            ImageView infoView = new ImageView(getClass().getResource("/movieInfo/" + (i + 1 ) + ".jpeg").toExternalForm());
            StackPane stackPaneMovie = new StackPane(movieView);
            StackPane stackPaneInfo = new StackPane(infoView);
            RXCarouselPane myMoviePane = new RXCarouselPane(stackPaneMovie);
            RXCarouselPane myInfoPane = new RXCarouselPane(stackPaneInfo);
            picCarousel.setCarouselAnimation(new AnimCircle());
            infoCarousel.setCarouselAnimation(new AnimCorner());
            moviesPics.add(myMoviePane);
            moviesInfo.add(myInfoPane);
        }
        picCarousel.setAutoSwitch(false);
        infoCarousel.setAutoSwitch(false);
        infoCarousel.arrowDisplayModeProperty();
        picCarousel.setPaneList(moviesPics);
        infoCarousel.setPaneList(moviesInfo);

    }

    //onAction. When clicking buttons, the scene would be loaded to recommendView.
    public void switchToGPT (ActionEvent register) throws IOException {
        root = FXMLLoader.load(getClass().getResource("recommendGPT.fxml"));
        stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        System.out.println("Switching to Comment");
    }
}
