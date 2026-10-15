/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.lab08;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author 2584955 Patrick Huy The Tran
 */
public class PainterController implements Initializable {

    @FXML
    private RadioButton blackRadioButton;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton redRadioButton;
    @FXML
    private RadioButton greenRadioButton;
    @FXML
    private RadioButton blueRadioButton;
    @FXML
    private RadioButton smallRadioButton;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton largeRadioButton;
    @FXML
    private Button undoButton;
    @FXML
    private Button clearButton;
    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        Color color = (Color) colorToggleGroup.getSelectedToggle().getUserData();
        brushColor = color;
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        double r = radius.getRadius();
        
        Circle drawnCircle = new Circle(x, y, r, brushColor);
        
        if (x >= r && x <= drawingAreaPane.getWidth()) {
            if (y >= r && y <= drawingAreaPane.getHeight()) {
                drawingAreaPane.getChildren().add(drawnCircle);
            }
        }
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        PenSize penSize = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
        radius = penSize;
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        int numOfElements = drawingAreaPane.getChildren().size();
        
        if (numOfElements > 0) {
            drawingAreaPane.getChildren().remove(numOfElements - 1);
        }
    }
    
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
     /**
     * used to specify each RadioButton’s corresponding 
     * user data object either a Color or a PenSize.
     */
    public void initialize() {
        //user data on a control can be any Object
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }    
    
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        
        PenSize(int radius) {this.radius = radius;}
        
        public int getRadius() {return radius;}
    };
}
