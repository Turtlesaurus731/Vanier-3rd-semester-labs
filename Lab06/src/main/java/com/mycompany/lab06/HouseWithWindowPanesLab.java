/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author Patrick Huy The Tran
 */
public class HouseWithWindowPanesLab extends Application{
    @Override
    public void start(Stage stage) {
        Rectangle centerWall = new Rectangle(50, 50, 250, 250);
        centerWall.setStroke(Color.BLACK);
        centerWall.setFill(null);
        
        Rectangle base = new Rectangle(50, 250, 250, 50);
        base.setStroke(Color.BEIGE);
        base.setFill(null);
        
        Rectangle door = new Rectangle();
        Rectangle chimney = new Rectangle();
        Rectangle window1 = new Rectangle();
        Rectangle window2 = new Rectangle();
        Polygon roof = new Polygon(0, 25, 50, 50, 100, 100);
        roof.setStroke(Color.RED);
        roof.setFill(null);
        
        Pane root = new Pane(
                centerWall, base, door, chimney, window1, window2, roof
        );
        
        Scene scene = new Scene(root, 520.0, 520.0);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
