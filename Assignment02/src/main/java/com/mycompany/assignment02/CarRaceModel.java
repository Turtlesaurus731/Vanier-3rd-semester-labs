/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02;

import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author patrick huy the tran
 */
public class CarRaceModel {
    private String carType;
    private int carNumber;
    private double xPosition;
    private double yPosition;
    private double speed;
    private Color color;
    private double travelDurationMillis;
    
    private static final Random random = new Random();

    public CarRaceModel(String carType, int carNumber, Color color, double initialX, double initialY) {
        this.carType = carType;
        this.carNumber = carNumber;
        this.color = color;
        this.xPosition = initialX;
        this.yPosition = initialY;
        
        // Generate a random speed factor 
        // Ranges from 20 px/s to ~30 px/s over the 400px distance
        this.speed = 20.0 + (10.0 * random.nextDouble());
        
        // Calculate transition duration based on speed (400 pixels len)
        calculateDuration(400.0);
    }

    /**
     * Calculates travel duration from the distance and the generated random speed.
     * @param targetDistance The distance to the finish line
     */
    public void calculateDuration(double targetDistance) {
        // Higher speed results in lower duration (faster car)
        this.travelDurationMillis = (targetDistance / speed) * 120.0;
    }

    // Getters and Setters
    public String getCarType() { return carType; }
    public int getCarNumber() { return carNumber; }
    public double getXPosition() { return xPosition; }
    public void setXPosition(double xPosition) { this.xPosition = xPosition; }
    public double getYPosition() { return yPosition; }
    public double getSpeed() { return speed; }
    public Color getColor() { return color; }
    public double getTravelDurationMillis() { return travelDurationMillis; }
}
