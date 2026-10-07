package com.mycompany.lab07;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
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
        HBox bottomBox = new HBox(10);
        bottomBox.setAlignment(Pos.CENTER);
        
        Line lineMN = new Line(200, 200, 600, 200);
        Line lineNP = new Line(600, 200, 600, 500);
        Line linePQ = new Line(600, 500, 200, 500);
        Line lineQM = new Line(200, 500, 200, 200);
        
        Image image = new Image("/cat.jpeg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); 
        imageView.setPreserveRatio(true);
        imageView.setX(200);
        imageView.setY(200);
        
        Image imageB = new Image("/cat2.jpg");
        ImageView imageViewB = new ImageView(imageB);
        imageViewB.setFitWidth(50); 
        imageViewB.setPreserveRatio(true);
        imageViewB.setX(350); 
        imageViewB.setY(325);
        
        PathTransition transitionMN = new PathTransition();
        transitionMN.setDuration(Duration.millis(1500));
        transitionMN.setNode(imageView);
        transitionMN.setPath(lineMN);
        transitionMN.setRate(-1.0);
        transitionMN.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        
        PathTransition transitionNP = new PathTransition();
        transitionNP.setDuration(Duration.millis(1500));
        transitionNP.setNode(imageView);
        transitionNP.setPath(lineNP);
        transitionNP.setRate(-1.0);
        transitionNP.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        
        PathTransition transitionPQ = new PathTransition();
        transitionPQ.setDuration(Duration.millis(1500));
        transitionPQ.setNode(imageView);
        transitionPQ.setPath(linePQ);
        transitionPQ.setRate(-1.0);
        transitionPQ.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        
        PathTransition transitionQM = new PathTransition();
        transitionQM.setDuration(Duration.millis(1500));
        transitionQM.setNode(imageView);
        transitionQM.setPath(lineQM);
        transitionQM.setRate(-1.0);
        transitionQM.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        
        FadeTransition fadeB = new FadeTransition(
                Duration.millis(1500), imageViewB
        );  
        fadeB.setFromValue(1.0);
        fadeB.setToValue(0.25);
        
        ScaleTransition scaleB = new ScaleTransition(
                Duration.millis(1500), imageViewB
        );
        scaleB.setFromX(1.0);
        scaleB.setFromY(1.0);
        scaleB.setToX(2.0);
        scaleB.setToY(2.0);
        
        RotateTransition rotateB = new RotateTransition(
                Duration.millis(1500), imageViewB
        );
        rotateB.setByAngle(360);
        
        TranslateTransition moveB = new TranslateTransition(
                Duration.millis(1500), imageViewB
        );
        moveB.setByY(-100);
        
        SequentialTransition seqA = new SequentialTransition(
                transitionMN, transitionNP, transitionPQ, transitionQM
        );
        
        SequentialTransition seqB = new SequentialTransition(
                fadeB, scaleB, rotateB, moveB
        );
        
        ParallelTransition animation = new ParallelTransition(seqA, seqB);
        animation.play();        
        
        upperPane.getChildren().addAll(imageView, imageViewB);
        
        Button startBtn = new Button("Start");
        Button resetBtn = new Button("Reset");
        Button exitBtn = new Button("Exit");
        startBtn.setPrefWidth(200);
        resetBtn.setPrefWidth(200);
        exitBtn.setPrefWidth(200);
        
        startBtn.setOnAction(e -> animation.play());
        
        resetBtn.setOnAction(e ->{
            animation.stop();
            imageViewB.setOpacity(1.0);
            imageViewB.setScaleX(1.0);
            imageViewB.setScaleY(1.0);
            imageViewB.setRotate(0);
            imageViewB.setTranslateY(0);
            imageView.setTranslateX(0);
            imageView.setTranslateY(0);
        });
        
        bottomBox.getChildren().addAll(startBtn, resetBtn, exitBtn);
        
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
