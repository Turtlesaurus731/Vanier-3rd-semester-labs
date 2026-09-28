package com.mycompany.lab05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        HBox bottomAreaBox = new HBox(100);
        
        ListView<String> listView = new ListView();
        listView.getItems().addAll(
                "Full Decorative", 
                "Beaded", 
                "Pirate Design",
                "Fringed",
                "Leather",
                "Plain"
        );
        listView.getSelectionModel().select(0);
        
        ComboBox<Integer> comboBox = new ComboBox();
        comboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        comboBox.setValue(1);
        
        RadioButton smallButton = new RadioButton("small");
        RadioButton mediumButton = new RadioButton("medium");
        RadioButton largeButton = new RadioButton("large");
        smallButton.setUserData("small ");
        mediumButton.setUserData("medium ");
        largeButton.setUserData("large ");
        
        ToggleGroup radioGroup = new ToggleGroup();
        radioGroup.getToggles().addAll(smallButton, mediumButton, largeButton);
        smallButton.setSelected(true);
        
        Button orderButton = new Button("Order");
        Button clearButton = new Button("Clear");
        Label orderLabel = new Label("Your order will apear here once processed");
        
        gridPane.add(listView, 0, 0);
        gridPane.add(comboBox, 0, 1);
        gridPane.add(smallButton, 1, 1);
        gridPane.add(mediumButton, 2, 1);
        gridPane.add(largeButton, 3, 1);
        bottomAreaBox.getChildren().addAll(orderButton, clearButton, orderLabel);
        
        orderButton.setOnAction(eh -> {
            String selectedBagType = listView.getSelectionModel().getSelectedItem();
            
            int number = comboBox.getSelectionModel().getSelectedItem();
            String size = radioGroup.getSelectedToggle().getUserData().toString();
            
            orderLabel.setText(
                    "You ordered " 
                            + number 
                            + " " + size 
                            + selectedBagType + " bag.");
        });
        
        clearButton.setOnAction(eh -> {
            orderLabel.setText("Your order will apear here once processed");
            listView.getSelectionModel().select(0);
            comboBox.setValue(1);
            smallButton.setSelected(true);
        });
        
        root.setCenter(gridPane);
        root.setBottom(bottomAreaBox);
        Scene scene = new Scene(root, 700, 500);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}