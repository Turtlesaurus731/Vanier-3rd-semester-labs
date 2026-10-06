package com.mycompany.lab07;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
      /* 
        stage.setTitle("Fading Demo");
        final Scene scene = new Scene(new Group(), 600, 450);
        scene.setFill(Color.WHITE);
        Rectangle rectFade = new Rectangle(100, 150, 100, 100);
        rectFade.setX(10); //set top-left corner x coordinate of property X
        rectFade.setY(250); //set top-left corner y coordinate
        rectFade.setArcHeight(20);
        rectFade.setArcWidth(20);
        rectFade.setFill(Color.RED);
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rectFade);
        ft.setFromValue(1.0);
        ft.setToValue(0.5); //if 0, fully transparent
//        ft.setCycleCount(Timeline.INDEFINITE);
//        ft.setAutoReverse(true);
        ft.setCycleCount(3);
        ft.setAutoReverse(false);
        ft.play();
        ((Group)scene.getRoot()).getChildren().addAll(rectFade); 
        //error message if cast operator missing
        stage.setScene(scene);
        stage.show(); 
      
        stage.setTitle("Transitions Demo");
        final Scene scene = new Scene(new Group(), 800,300);
        scene.setFill(Color.WHITE);
        Rectangle rectSeq = new Rectangle(0,0,50, 50);
        rectSeq.setFill(Color.DARKBLUE);
        //rectSeq.setTranslateX(100);
        rectSeq.setTranslateY(200);
        TranslateTransition translateTransition = new
        TranslateTransition(Duration.millis(2000), rectSeq);
        //translateTransition.setFromX(500);
        //translateTransition.setToX(550);
        //translateTransition.setFromY(100);
        translateTransition.setToY(250);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        ((Group)scene.getRoot()).getChildren().addAll(rectSeq);
        translateTransition.play();
        stage.setScene(scene);
        stage.show(); */
        BorderPane root = new BorderPane();
        Pane upperPane = new Pane();
        HBox bottomBox = new HBox();
        
        Rectangle rectangleMNPQ = new Rectangle(600, 400);
        
        Image image = new Image("/cat.jpeg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); 
        imageView.setPreserveRatio(true);
        
//        Path path = new Path();
//        path.getElements().add(new MoveTo (0, 50));
//        path.getElements().add(new CubicCurveTo (40, 10, 390, 240, 1904, 50));
        
        PathTransition pathTransition = 
                new PathTransition();
 
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(imageView);
        pathTransition.setPath(rectangleMNPQ);
        pathTransition.setRate(-1.0);
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.play();
        
        upperPane.getChildren().addAll(imageView);
        
        root.setCenter(upperPane);
        root.setBottom(bottomBox);
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}