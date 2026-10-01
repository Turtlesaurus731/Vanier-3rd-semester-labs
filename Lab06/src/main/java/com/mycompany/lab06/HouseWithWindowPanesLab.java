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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        Rectangle grass = new Rectangle(0, 440, 520, 80);
        grass.setStroke(Color.BLACK);
        grass.setFill(Color.GREEN);
        
        Rectangle centerWall = new Rectangle(130, 260, 260, 170);
        centerWall.setStroke(Color.BLACK);
        centerWall.setFill(Color.BROWN);
        
        Rectangle base = new Rectangle(130, 430, 250, 10);
        base.setStroke(Color.BLACK);
        base.setFill(Color.BEIGE);
        
        Rectangle door = new Rectangle(230, 330, 60, 90);
        door.setFill(Color.BISQUE);
        door.setStroke(Color.BLACK);
        
        Rectangle chimney = new Rectangle(230, 160, 30, 70);
        chimney.setFill(Color.GRAY);
        chimney.setStroke(Color.BLACK);
        
        Rectangle window1 = new Rectangle(160, 285, 45, 45);
        window1.setStroke(Color.STEELBLUE);
        window1.setFill(Color.AQUAMARINE);
        Line window1Horizontal = new Line(160, 307, 205, 307);
        window1Horizontal.setStroke(Color.STEELBLUE);
        Line window1Vertical = new Line(182, 285, 182, 330);
        window1Vertical.setStroke(Color.STEELBLUE);
        
        Rectangle window2 = new Rectangle(310, 285, 45, 45);
        window2.setArcWidth(20);  
        window2.setArcHeight(20);
        window2.setStroke(Color.STEELBLUE);
        window2.setFill(Color.AQUAMARINE);
        Line window2Horizontal = new Line(310, 307, 355, 307);
        window2Horizontal.setStroke(Color.STEELBLUE);
        Line window2Vertical = new Line(332, 285, 332, 330);
        window2Vertical.setStroke(Color.STEELBLUE);
        
        Polygon roof = new Polygon(260, 150, 130, 260, 390, 260);
        roof.setStroke(Color.DARKRED);
        roof.setFill(Color.RED);
        
        Circle sun = new Circle(460, 80, 40);
        sun.setFill(Color.YELLOW);
        Line ray1 = new Line(425, 60, 390, 85);
        Line ray2 = new Line(430, 105, 385, 140);
        Line ray3 = new Line(460, 120, 440, 160);

        Line[] rays = {ray1, ray2, ray3};
        for (Line ray : rays) {
            ray.setStroke(Color.YELLOW);
            ray.setStrokeWidth(2);
        }
        
        Pane root = new Pane(
                grass, chimney, roof, centerWall, base, door, 
                window1, window2, window1Horizontal, window1Vertical,
                window2Horizontal, window2Vertical,sun, ray1, ray2, ray3
        );
        
        Scene scene = new Scene(root, 520.0, 520.0);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
