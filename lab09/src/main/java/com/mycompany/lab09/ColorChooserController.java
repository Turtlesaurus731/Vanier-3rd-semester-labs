/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.lab09;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 * FXML Controller class
 *
 * @author 2584955 Patrick Huy The Tran
 */
public class ColorChooserController implements Initializable {
    private int red = 0;
    private int blue = 0;
    private int green = 0;
    private double alpha = 1.0;

    @FXML
    private Slider greenSlider;
    @FXML
    private Slider redSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider alphaSlider;
    @FXML
    private TextField redTextField;
    @FXML
    private TextField blueTextField;
    @FXML
    private TextField greenTextField;
    @FXML
    private TextField alphaTextField;
    @FXML
    private Circle colorCircle;
    @FXML
    private Rectangle colorRectangle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        redTextField.textProperty().bind(
                redSlider.valueProperty().asString("%.0f"));
        
        blueTextField.textProperty().bind(
                blueSlider.valueProperty().asString("%.0f"));
        
        greenTextField.textProperty().bind(
                greenSlider.valueProperty().asString("%.0f"));
        
        alphaTextField.textProperty().bind(
                alphaSlider.valueProperty().asString("%.2f"));
        
        redSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
        blueSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
        greenSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
        alphaSlider.valueProperty().addListener((ov, oldValue, newValue) -> updateColor());
    }    
    
    public void updateColor() {
        red = (int) redSlider.getValue();
        blue = (int) blueSlider.getValue();
        green = (int) greenSlider.getValue();
        alpha = alphaSlider.getValue();
        
        colorRectangle.setFill(Color.rgb(red, green, blue));
        colorRectangle.setOpacity(alpha);
    }
    
    private class ColorSliderListener implements ChangeListener<Number> {
        private TextField textfield; 

        public ColorSliderListener() {
            this.textfield = textfield;
        }
        
        @Override
        public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
            updateColor();
        }
    }
}
