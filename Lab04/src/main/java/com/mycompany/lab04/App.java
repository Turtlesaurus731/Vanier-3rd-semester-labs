package com.mycompany.lab04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        root.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        
        Label numOfDaysOnTrip = new Label("Number of days on the trip: ");
        Label amountOfAirfare = new Label("Amount of airfare (if anny): ");
        Label amountCarFees = new Label("Amount of car rental fees (if any): ");
        Label numberMilesDriven = new Label("Number of miles driven "
                + "(if private vehicle was used): ");
        Label amountParkingFee = new Label("Amount of parking fees (if any): ");
        Label amountTaxiCharges = new Label("Amount of taxi charges (if any): ");
        Label conferenceFees = new Label("Conference/Seminar fees (if any): ");
        Label lodgingCharges = new Label("Lodging charges per night: ");
        
        TextField numDaysField = new TextField();
        TextField airfareField = new TextField();
        TextField carFeeField = new TextField();
        TextField numDrivenField = new TextField();
        TextField parkingFeeField = new TextField();
        TextField taxiFeeField = new TextField();
        TextField conferenceFeeField = new TextField();
        TextField lodgingFeeField = new TextField();
        
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}