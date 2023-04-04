package com.example.moviemanagement;


import com.leewyatt.rxcontrols.animation.carousel.AnimAround;
import com.leewyatt.rxcontrols.animation.carousel.AnimFade;
import com.leewyatt.rxcontrols.controls.RXCarousel;
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
    private RXCarousel movieCarousel;


    @FXML
    void initialize() {
        carouselInitialize();
    }

    private void carouselInitialize() {
        String[] classicMovie = {"The Shawshank Redemption","Forrest Gump","Leon"};
        ArrayList<RXCarouselPane> myMovies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView movieView = new ImageView(getClass().getResource("/homeMovie/" + (i + 1 ) + ".jpeg").toExternalForm());
            Label movieLabel = new Label(classicMovie[i]);
            movieLabel.setPrefSize(250, 35);
            movieLabel.setStyle("-fx-alignment: center;-fx-background-color:transparent;-fx-text-fill:black;-fx-font-size: 20");
            StackPane stackPane = new StackPane(movieView, movieLabel);
            RXCarouselPane myMoviePane = new RXCarouselPane(stackPane);
            movieCarousel.setCarouselAnimation(new AnimAround(true));
            movieLabel.setTranslateY(215);
            Duration T = new Duration(1100);
            movieCarousel.animationTimeProperty().set(T);
            TranslateTransition myOpened = new TranslateTransition(Duration.millis(0), movieLabel);
            myMoviePane.setOnOpened(event -> {
                myOpened.play();
                event.consume();
            });
            TranslateTransition myClosing = new TranslateTransition(Duration.millis(0), movieLabel);
            myMoviePane.setOnClosing(event -> {
                myClosing.play();
                event.consume();
            });
            myMovies.add(myMoviePane);
        }
        movieCarousel.setPaneList(myMovies);
    }

        public void switchToComment (ActionEvent register) throws IOException {
            root = FXMLLoader.load(getClass().getResource("movieComment.fxml"));
            stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
            System.out.println("Switching to Comment");

        }


        public void switchToLogin (ActionEvent register) throws IOException {
            root = FXMLLoader.load(getClass().getResource("loginView.fxml"));
            stage = (Stage) ((Node) register.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
            System.out.println("Switching to CommonUser");
        }


    }
