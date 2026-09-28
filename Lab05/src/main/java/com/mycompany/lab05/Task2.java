/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab05;

import java.util.LinkedHashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 2584955
 */
public class Task2 extends Application{
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        
        String[] category = {"Beverage", "Appetizer", "Main Course", "Dessert"};
        Map<String, Double> beverageMap = new LinkedHashMap<>();
        Map<String, Double> appetizerMap = new LinkedHashMap<>();
        Map<String, Double> mainCourseMap = new LinkedHashMap<>();
        Map<String, Double> desserMap = new LinkedHashMap<>();
        
        beverageMap.put("Coffee", 2.50);
        beverageMap.put("Tea", 2.00);
        beverageMap.put("Soft Drink", 1.75);
        beverageMap.put("Water", 2.95);
        beverageMap.put("Milk", 1.50);
        beverageMap.put("Juice", 2.50);
        
        appetizerMap.put("Soup", 4.50);
        appetizerMap.put("Salad", 3.75);
        appetizerMap.put("Spring Rolls", 5.25);
        appetizerMap.put("Garlic Bread", 3.00);
        appetizerMap.put("Chips and Salsa", 6.95);
        
        mainCourseMap.put("Steak", 15.00);
        mainCourseMap.put("Grilled Chicken", 13.50);
        mainCourseMap.put("Chicken Alfredo", 13.95);
        mainCourseMap.put("Turkey Club", 11.90);
        mainCourseMap.put("Shrimp Scampi", 18.99);
        mainCourseMap.put("Pasta", 11.75);
        mainCourseMap.put("Fish and Chips", 12.25);
        
        desserMap.put("Apple Pie", 5.95);
        desserMap.put("Carrot Cake", 4.50);
        desserMap.put("Mud Pie", 4.75);
        desserMap.put("Pudding", 3.25);
        desserMap.put("Apple Crisp", 5.98);
        
        ComboBox beverageBox = new ComboBox();
        ComboBox appetizerBox = new ComboBox();
        ComboBox mainCourseBox = new ComboBox();
        ComboBox dessetBox = new ComboBox();
        
        for (int i = 0; i < category.length; i++) {
            
        }
        
        Scene scene = new Scene(root, 700, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
