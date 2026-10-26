/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.lab09;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
/**
 * FXML Controller class
 *
 * @author 2584955
 */
public class ColorChooserController implements Initializable {


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
        // TODO
    }    
    
}
