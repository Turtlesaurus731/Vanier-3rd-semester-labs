package com.mycompany.lab06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * JavaFX App
 * @author Patrick Huy The Tran
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
    // Constants for the scene size
    final double SCENE_WIDTH = 520.0;
    final double SCENE_HEIGHT = 520.0;

    // Constants for each square's XY coordinates
    final int X1 = 10, Y1 = 10; // Square #1
    final int X2 = 60, Y2 = 60; // Square #1
    final int X3 = 110, Y3 = 110; // Square #3

    // Constants for each square's width and height
    final int WIDTH1 = 500, HEIGHT1 = 500; // Square #1
    final int WIDTH2 = 400, HEIGHT2 = 400; // Square #2
    final int WIDTH3 = 300, HEIGHT3 = 300; // Square #3

    // Constants for the circle's geometry
    final int CENTER_X = 260, CENTER_Y = 260, RADIUS = 150;

    // Create square #1 here. Set its stroke color to black
    // and set its fill color to null.
    
    Rectangle rectangle = new Rectangle(X1, Y1, WIDTH1, HEIGHT1);
    rectangle.setStroke(Color.BLACK);
    rectangle.setFill(null);

    // Create square #2 here. Set its stroke color to black
    // and set its fill color to null.
    
    Rectangle rectangle2 = new Rectangle(X2, Y2, WIDTH2, HEIGHT2);
    rectangle2.setStroke(Color.BLACK);
    rectangle2.setFill(null);
    
    // Create square #3 here. Set its stroke color to black
    // and set its fill color to null.
    
    Rectangle rectangle3 = new Rectangle(X3, Y3, WIDTH3, HEIGHT3);
    rectangle3.setStroke(Color.BLACK);
    rectangle3.setFill(null);
    
    // Create the diagonal lines here.
    
    Line line1 = new Line(X1, Y1, X3, Y3);
    Line line2 = new Line(X1 + WIDTH1, Y1, X3 + WIDTH3, Y3);
    Line line3 = new Line(X1, Y1 + HEIGHT1, X3, Y3 + HEIGHT3);
    Line line4 = new Line(X1 + WIDTH1,Y1 + HEIGHT1, X3 + WIDTH3, Y3 + HEIGHT3);
    
    // Create the circle here.
    
    Circle circle = new Circle(CENTER_X, CENTER_Y, RADIUS);
    
    // Add the nodes to a Pane here.
    StackPane root = new StackPane(
            rectangle, rectangle2, rectangle3,
            line1, line2, line3, line4, circle
    );
    
    // Create a Scene with the Pane as the root node,
    Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    primaryStage.setScene(scene);
    // and display it here.
    primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}