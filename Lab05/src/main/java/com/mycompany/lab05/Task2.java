/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab05;

import java.util.LinkedHashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2584955
 */
public class Task2 extends Application{
    private ComboBox<String> beverageBox;
    private ComboBox<String> appetizerBox;
    private ComboBox<String> mainCourseBox;
    private ComboBox<String> dessertBox;
    private Map<String, Double> beverageMap = new LinkedHashMap<>();
    private Map<String, Double> appetizerMap = new LinkedHashMap<>();
    private Map<String, Double> mainCourseMap = new LinkedHashMap<>();
    private Map<String, Double> dessertMap = new LinkedHashMap<>();
    private Slider tipSlider;

    private final double TAX_RATE = 0.14975;
    
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        GridPane bottomArea = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20));
        bottomArea.setHgap(10);
        bottomArea.setVgap(10);
        bottomArea.setPadding(new Insets(10));
     
        String[] category = {"Beverage: ", "Appetizer: ", "Main Course: ", "Dessert: "};

        beverageMap.put("None", 0.00);
        beverageMap.put("Coffee", 2.50);
        beverageMap.put("Tea", 2.00);
        beverageMap.put("Soft Drink", 1.75);
        beverageMap.put("Water", 2.95);
        beverageMap.put("Milk", 1.50);
        beverageMap.put("Juice", 2.50);
        
        appetizerMap.put("None", 0.00);
        appetizerMap.put("Soup", 4.50);
        appetizerMap.put("Salad", 3.75);
        appetizerMap.put("Spring Rolls", 5.25);
        appetizerMap.put("Garlic Bread", 3.00);
        appetizerMap.put("Chips and Salsa", 6.95);
        
        mainCourseMap.put("None", 0.00);
        mainCourseMap.put("Steak", 15.00);
        mainCourseMap.put("Grilled Chicken", 13.50);
        mainCourseMap.put("Chicken Alfredo", 13.95);
        mainCourseMap.put("Turkey Club", 11.90);
        mainCourseMap.put("Shrimp Scampi", 18.99);
        mainCourseMap.put("Pasta", 11.75);
        mainCourseMap.put("Fish and Chips", 12.25);
        
        dessertMap.put("None", 0.00);
        dessertMap.put("Apple Pie", 5.95);
        dessertMap.put("Carrot Cake", 4.50);
        dessertMap.put("Mud Pie", 4.75);
        dessertMap.put("Pudding", 3.25);
        dessertMap.put("Apple Crisp", 5.98);
        
        beverageBox = new ComboBox<>();
        appetizerBox = new ComboBox<>();
        mainCourseBox = new ComboBox<>();
        dessertBox = new ComboBox<>();
        
        beverageBox.setPrefWidth(150);
        appetizerBox.setPrefWidth(150);
        mainCourseBox.setPrefWidth(150);
        dessertBox.setPrefWidth(150);
        
        beverageBox.getItems().addAll(beverageMap.keySet());
        appetizerBox.getItems().addAll(appetizerMap.keySet());
        mainCourseBox.getItems().addAll(mainCourseMap.keySet());
        dessertBox.getItems().addAll(dessertMap.keySet());
         
        for (int i = 0; i < category.length; i++) {
            gridPane.add(new Label(category[i]), i, 0);
        }
        
        gridPane.add(beverageBox, 0, 1);
        gridPane.add(appetizerBox, 1, 1);
        gridPane.add(mainCourseBox, 2, 1);
        gridPane.add(dessertBox, 3, 1);
        
        Label subtotal = new Label("Subtotal:");
        Label tax = new Label("Tax:");
        Label tip = new Label("Tip:");
        Label total = new Label("Total:");
        Label subtotalLabel = new Label("0.00$");
        Label taxLabel = new Label("0.00$");
        Label tipLabel = new Label("0.00$");
        Label totalLabel = new Label("0.00$");
        
        tipSlider = new Slider(0, 20, 0);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        tipSlider.setPrefWidth(400);
        
        Button clearButton = new Button("Clear");
           
        bottomArea.add(subtotal, 0, 0);
        bottomArea.add(subtotalLabel, 1, 0);
        bottomArea.add(tax, 0, 1);
        bottomArea.add(taxLabel, 1, 1);
        bottomArea.add(tip, 0, 2);
        bottomArea.add(tipLabel, 1, 2);
        bottomArea.add(total, 0, 3);
        bottomArea.add(totalLabel, 1, 3);
        bottomArea.add(new Label("Tip in %: "), 0, 4);
        bottomArea.add(tipSlider, 1, 4);
        bottomArea.add(clearButton, 1, 5);
        
        beverageBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateBill(subtotalLabel, taxLabel, tipLabel, totalLabel);
        });
        
        appetizerBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateBill(subtotalLabel, taxLabel, tipLabel, totalLabel);
        });
        
        mainCourseBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateBill(subtotalLabel, taxLabel, tipLabel, totalLabel);
        });
        
        dessertBox.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateBill(subtotalLabel, taxLabel, tipLabel, totalLabel);
        });
        
        tipSlider.valueProperty().addListener(
                (observable, oldValu, newValue) -> {
                    updateBill(subtotalLabel, taxLabel, tipLabel, totalLabel);
        });
        
        root.setCenter(gridPane);
        root.setBottom(bottomArea);
        Scene scene = new Scene(root, 700, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    /**
     * Calculates the subtotal from the selected foods 
     * @return the subtotal
     */
    private double calculateSubtotal() {
        double subtotalValue = 0.0;

        if (beverageBox.getValue() != null) {
            subtotalValue += beverageMap.get(beverageBox.getValue());
        }
        if (appetizerBox.getValue() != null) {
            subtotalValue += appetizerMap.get(appetizerBox.getValue());
        }
        if (mainCourseBox.getValue() != null) {
            subtotalValue += mainCourseMap.get(mainCourseBox.getValue());
        }
        if (dessertBox.getValue() != null) {
            subtotalValue += dessertMap.get(dessertBox.getValue());
        }
        return subtotalValue;
    }
    
    /**
     * Updates the subtotal, tax label and tip label
     * @param subtotalLabel the label used to display the current subtotal
     * @param taxLabel the label used to display the current tax
     * @param tipLabel the label used to display the current tip
     * @param totalLabel the label used to display the current total
     */
    private void updateBill(
            Label subtotalLabel,
            Label taxLabel,
            Label tipLabel,
            Label totalLabel) {
                double subtotalValue = calculateSubtotal();
                double taxValue = subtotalValue * TAX_RATE;
                double tipPercentage = tipSlider.getValue();
                double tipValue = subtotalValue * (tipPercentage / 100);
                double totalValue = subtotalValue + taxValue + tipValue;

                subtotalLabel.setText(String.format("%.2f$", subtotalValue));
                taxLabel.setText(String.format("%.2f$", taxValue));
                tipLabel.setText(String.format("%.2f$", tipValue));
                totalLabel.setText(String.format("%.2f$", totalValue));
    }
}
