package com.VanierPatrick.lab03;

import javafx.application.Application;
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
        GridPane gridPane = new GridPane(2, 7);
        root.setCenter(gridPane);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        Label firstName = new Label("FirstName");
        Label LastName = new Label("LastName");
        Label email = new Label("Email");
        Label password = new Label("Password");
        
        TextField firstNameField = new TextField("");
        TextField lastNameField = new TextField("");
        TextField emailField = new TextField("");
        TextField passwordField = new TextField("");
        
        gridPane.add(firstName, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(LastName, 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(email, 0, 2);
        gridPane.add(emailField, 1, 2);
        gridPane.add(password, 0, 3);
        gridPane.add(passwordField, 1, 3);
        
        
        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}