/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment02;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
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
    
    
    private TranslateTransition moveCar1, moveCar2, moveCar3, moveCar4;
    private RotateTransition spinWheel1A, spinWheel1B, spinWheel2A, spinWheel2B, 
                             spinWheel3A, spinWheel3B, spinWheel4A, spinWheel4B;
    private ParallelTransition raceAnimation;

    private final double FINISH_LINE_X = 400.0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        buildAnimations();
    }
    
    private void buildAnimations() {
        Random random = new Random();
        // With a randomized time, I create TranslateTransitions for each car
        moveCar1 = new TranslateTransition(
                Duration.millis(3000 + random.nextInt(2000)), car01);
        moveCar1.setToX(FINISH_LINE_X);

        moveCar2 = new TranslateTransition(
                Duration.millis(3000 + random.nextInt(2000)), car02);
        moveCar2.setToX(FINISH_LINE_X);

        moveCar3 = new TranslateTransition(
                Duration.millis(3000 + random.nextInt(2000)), car03);
        moveCar3.setToX(FINISH_LINE_X);

        moveCar4 = new TranslateTransition(
                Duration.millis(3000 + random.nextInt(2000)), car04);
        moveCar4.setToX(FINISH_LINE_X);
        
        // Create the RotateTransition for each wheel with a method
        spinWheel1A = createWheelRotator(wheelCar01A);
        spinWheel1B = createWheelRotator(wheelCar01B);
        spinWheel2A = createWheelRotator(wheelCar02A);
        spinWheel2B = createWheelRotator(wheelCar02B);
        spinWheel3A = createWheelRotator(wheelCar03A);
        spinWheel3B = createWheelRotator(wheelCar03B);
        spinWheel4A = createWheelRotator(wheelCar04A);
        spinWheel4B = createWheelRotator(wheelCar04B);
        
        // Group all the Transitions into a parralel transition
        raceAnimation = new ParallelTransition(
            moveCar1, moveCar2, moveCar3, moveCar4,
            spinWheel1A, spinWheel1B, spinWheel2A, spinWheel2B,
            spinWheel3A, spinWheel3B, spinWheel4A, spinWheel4B
        );    
    }
    
    /**
     * Creates a RotateTransition for a car wheel that will rotate 360 degrees 
     * as long as needed.
     * @param wheel The group of circles and lines that form a wheel of a car
     * @return the RotateTransition that is set to rotate indefinitely 
     */
    private RotateTransition createWheelRotator(Group wheel) {
        RotateTransition rotate = 
                new RotateTransition(Duration.millis(400), wheel);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        return rotate;
        //TODO: have the wheels not rotate indefinitly/ stop at target desti. 
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
        // TODO
        raceAnimation.stop();
        car01.setTranslateX(0);
        car02.setTranslateX(0);
        car03.setTranslateX(0);
        car04.setTranslateX(0);
        buildAnimations();

        startBtn.setDisable(false);
        pauseBtn.setDisable(false);
    }
}

