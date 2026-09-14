package com.mycompany.lab04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
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
    private static Map<String, TextField> userInformtation;

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
        
        gridPane.add(numOfDaysOnTrip, 0, 0);
        gridPane.add(numDaysField,1, 0);
        gridPane.add(amountOfAirfare, 0, 1);
        gridPane.add(airfareField, 1, 1);
        gridPane.add(amountCarFees, 0, 2);
        gridPane.add(carFeeField, 1, 2);
        gridPane.add(numberMilesDriven, 0, 3);
        gridPane.add(numDrivenField, 1, 3);
        gridPane.add(amountParkingFee, 0, 4);
        gridPane.add(parkingFeeField, 1, 4);
        gridPane.add(amountTaxiCharges, 0, 5);
        gridPane.add(taxiFeeField, 1, 5);
        gridPane.add(conferenceFees, 0, 6);
        gridPane.add(conferenceFeeField, 1, 6);
        gridPane.add(lodgingCharges, 0, 7);
        gridPane.add(lodgingFeeField, 1, 7);
        
        this.userInformtation = new LinkedHashMap<>();
        
        userInformtation.clear();
        userInformtation.put("Days", numDaysField);
        userInformtation.put("Airefares", airfareField);
        userInformtation.put("Car fees", carFeeField);
        userInformtation.put("Miles driven", numDrivenField);
        userInformtation.put("Parking fees", parkingFeeField);
        userInformtation.put("Taxi fees", taxiFeeField);
        userInformtation.put("Conference/Seminar fees", conferenceFeeField);
        userInformtation.put("Lodging fees", lodgingFeeField);
        
        if (InputValidatior.validate(userInformtation)) {
            System.out.println("Test");
        }
        
        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Map<String, TextField> getUserInformtation() {
        return userInformtation;
    }
}
