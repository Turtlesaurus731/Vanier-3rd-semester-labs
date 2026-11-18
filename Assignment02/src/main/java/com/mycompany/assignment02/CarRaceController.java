/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author patrick huy the tran
 */
public class CarRaceController implements Initializable {

    @FXML
    private Pane car01;

    @FXML
    private Pane car02;

    @FXML
    private Pane car03;

    @FXML
    private Pane car04;

    @FXML
    private Label firstPlaceLabel;

    @FXML
    private Label fourthPlaceLabel;

    @FXML
    private Group groupCar01;

    @FXML
    private Group groupCar02;

    @FXML
    private Group groupCar03;

    @FXML
    private Group groupCar04;

    @FXML
    private Button pauseBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private VBox root;

    @FXML
    private Label secondPlaceLabel;

    @FXML
    private Label simulationSpeedLabel;

    @FXML
    private Slider simulationSpeedSlider;

    @FXML
    private Button startBtn;

    @FXML
    private Label thirdPlaceLabel;

    @FXML
    private Group wheelCar01A;

    @FXML
    private Group wheelCar01B;

    @FXML
    private Group wheelCar02A;

    @FXML
    private Group wheelCar02B;

    @FXML
    private Group wheelCar03A;

    @FXML
    private Group wheelCar03B;

    @FXML
    private Group wheelCar04A;

    @FXML
    private Group wheelCar04B;
    
    private CarRaceModel model1, model2, model3, model4;
    
    private TranslateTransition moveCar1, moveCar2, moveCar3, moveCar4;
    private RotateTransition spinWheel1A, spinWheel1B, spinWheel2A, spinWheel2B, 
                             spinWheel3A, spinWheel3B, spinWheel4A, spinWheel4B;
    private ParallelTransition raceAnimation;

    private final double FINISH_LINE_X = 400.0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (simulationSpeedLabel != null) {
                simulationSpeedLabel.setText(String.format(
                        "%.1fx", simulationSpeedSlider.getValue()
                ));
                
                simulationSpeedSlider.valueProperty().addListener(
                        (observable, oldValue, newValue) -> {
                            simulationSpeedLabel.setText(String.format(
                                    "%.1fx", newValue.doubleValue()
                            ));
                    
                    if (raceAnimation != null) {
                        raceAnimation.setRate(newValue.doubleValue());
                    }
                });
            }
        buildAnimations();
    }
    
    /**
     * Instantiates the 4 car models and makes sure all of them have unique speeds
     * This should help is avoid ties in the race
     */
    private void initializeUniqueModels() {
        boolean hasDuplicates = true;
        
        while (hasDuplicates) {
            // Instatiate car models
            model1 = new CarRaceModel("Racing Car",
                1, Color.DODGERBLUE, car01.getLayoutX(), car01.getLayoutY());
            model2 = new CarRaceModel("Racing Car",
                    2, Color.FORESTGREEN, car02.getLayoutX(), car02.getLayoutY());
            model3 = new CarRaceModel("Racing Car",
                    3, Color.PURPLE, car03.getLayoutX(), car03.getLayoutY());
            model4 = new CarRaceModel("Racing Car",
                    4, Color.RED, car04.getLayoutX(), car04.getLayoutY());
            
            // Hash set filters out coppies 
            Set<Double> durations = new HashSet<>(Arrays.asList(
                    model1.getTravelDurationMillis(),
                    model2.getTravelDurationMillis(),
                    model3.getTravelDurationMillis(),
                    model4.getTravelDurationMillis()
            ));
            
            if (durations.size() == 4) {
                hasDuplicates = false;
            }
        }
    }
    
    /**
     * Instantiates new car models with random speeds, sets up the 
     * ParallelTransition containing all the car animations and adjusts the
     * animation rate with the simulation speed slider. 
     * Also contains calls handleRaceFinished method when parallel transition end
     */
    private void buildAnimations() {
        // Instatiate car models
        initializeUniqueModels();     
        // Create TranslateTransitions using each model's randomized duration
        moveCar1 = new TranslateTransition(
                Duration.millis(model1.getTravelDurationMillis()), car01);
        moveCar1.setToX(FINISH_LINE_X);

        moveCar2 = new TranslateTransition(
                Duration.millis(model2.getTravelDurationMillis()), car02);
        moveCar2.setToX(FINISH_LINE_X);

        moveCar3 = new TranslateTransition(
                Duration.millis(model3.getTravelDurationMillis()), car03);
        moveCar3.setToX(FINISH_LINE_X);

        moveCar4 = new TranslateTransition(
                Duration.millis(model4.getTravelDurationMillis()), car04);
        moveCar4.setToX(FINISH_LINE_X);
        
        // Create the RotateTransition for each wheel with a method
        spinWheel1A = createWheelRotator(
                wheelCar01A, model1.getTravelDurationMillis());
        spinWheel1B = createWheelRotator(
                wheelCar01B, model1.getTravelDurationMillis());
        spinWheel2A = createWheelRotator(
                wheelCar02A, model2.getTravelDurationMillis());
        spinWheel2B = createWheelRotator(
                wheelCar02B, model2.getTravelDurationMillis());
        spinWheel3A = createWheelRotator(
                wheelCar03A, model3.getTravelDurationMillis());
        spinWheel3B = createWheelRotator(
                wheelCar03B, model3.getTravelDurationMillis());
        spinWheel4A = createWheelRotator(
                wheelCar04A, model4.getTravelDurationMillis());
        spinWheel4B = createWheelRotator(
                wheelCar04B, model4.getTravelDurationMillis());
        
        // Group all the Transitions into a parallel transition
        raceAnimation = new ParallelTransition(
            moveCar1, moveCar2, moveCar3, moveCar4,
            spinWheel1A, spinWheel1B, spinWheel2A, spinWheel2B,
            spinWheel3A, spinWheel3B, spinWheel4A, spinWheel4B
        );
        
        if (simulationSpeedSlider != null) {
           raceAnimation.setRate(simulationSpeedSlider.getValue());
        }
        
        raceAnimation.setOnFinished(e ->{
            handleRaceFinished();
        });
    }
    
    /**
     * Creates a RotateTransition for a car wheel that will rotate 360 degrees 
     * as long as needed.
     * @param wheel The group of circles and lines that form a wheel of a car
     * @param travelDurationMillis The duration of the car travels & wheel turns
     * @return the RotateTransition that is set to rotate indefinitely 
     */
    private RotateTransition createWheelRotator(Group wheel, double travelDurationMillis) {
        RotateTransition rotate = 
                new RotateTransition(Duration.millis(400), wheel);
        rotate.setByAngle(360);
        rotate.setCycleCount((int) (travelDurationMillis / 300));
        return rotate;
    }
    
    /**
     * Handles the end of the race by ranking the cars final result based on
     * duration and updates the labels accordingly
     */
    private void handleRaceFinished() {
        // Put car models into a list and sort them by duration
        List<CarRaceModel> rankedCars = new ArrayList<>(Arrays.asList(
                model1, model2, model3, model4
        ));
        rankedCars.sort(Comparator.comparingDouble(
                CarRaceModel::getTravelDurationMillis
        ));
        
        // Change the labels acording to the ranking
        if (firstPlaceLabel != null) {
            CarRaceModel winner = rankedCars.get(0);
            firstPlaceLabel.setText(String.format("Car #%d (%s)",
                    winner.getCarNumber(), winner.getColor().toString()
            ));
        }
        if (secondPlaceLabel != null) {
            CarRaceModel second = rankedCars.get(1);
            secondPlaceLabel.setText(String.format("Car #%d (%s)",
                    second.getCarNumber(), second.getColor().toString()
            ));
        }
        if (thirdPlaceLabel != null) {
            CarRaceModel third = rankedCars.get(2);
            thirdPlaceLabel.setText(String.format("Car #%d (%s)",
                    third.getCarNumber(), third.getColor().toString()
            ));
        }
        if (fourthPlaceLabel != null) {
            CarRaceModel fourth = rankedCars.get(3);
            fourthPlaceLabel.setText(String.format("Car #%d (%s)",
                    fourth.getCarNumber(), fourth.getColor().toString()
            ));
        }
        startBtn.setDisable(true);
        pauseBtn.setDisable(true);
    }
    
    @FXML
    private void onActionStartButton(ActionEvent actionEvent) {
        raceAnimation.play();
        startBtn.setDisable(true);
        pauseBtn.setDisable(false);
    }
    
    @FXML
    private void onActionPauseButton(ActionEvent actionEvent) {
        raceAnimation.pause();
        startBtn.setDisable(false);
    }
    
    @FXML
    private void onActionResetButton (ActionEvent actionEvent) {
        raceAnimation.stop();
        car01.setTranslateX(0);
        car02.setTranslateX(0);
        car03.setTranslateX(0);
        car04.setTranslateX(0);
        simulationSpeedSlider.setValue(1.0);
        buildAnimations();

        startBtn.setDisable(false);
        pauseBtn.setDisable(false);
    }
}

