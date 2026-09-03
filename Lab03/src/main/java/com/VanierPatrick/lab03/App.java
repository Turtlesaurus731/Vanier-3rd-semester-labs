package com.VanierPatrick.lab03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        
        Label firstName = new Label("FirstName");
        Label LastName = new Label("LastName");
        Label email = new Label("Email");
        Label password = new Label("Password");
        
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField emailField = new TextField();
        TextField passwordField = new TextField();
        
        Button registerBtn = new Button("Register");
        Button clearBtn = new Button("Clear");
        Label statusLabel = new Label(""); 
        
        gridPane.add(firstName, 0, 0);
        gridPane.add(firstNameField, 1, 0);
        gridPane.add(LastName, 0, 1);
        gridPane.add(lastNameField, 1, 1);
        gridPane.add(email, 0, 2);
        gridPane.add(emailField, 1, 2);
        gridPane.add(password, 0, 3);
        gridPane.add(passwordField, 1, 3);
        
        gridPane.add(registerBtn, 0, 4);
        gridPane.add(clearBtn, 1, 4);
        gridPane.add(statusLabel, 0, 5, 2, 1);
        registerBtn.setDisable(true);
        
        firstNameField.setOnKeyPressed(event -> {
            if (!firstNameField.getText().isEmpty()
                && !lastNameField.getText().isEmpty()
                && !emailField.getText().isEmpty()
                && !passwordField.getText().isEmpty()) {
                registerBtn.setDisable(false);
            } else {
                registerBtn.setDisable(true);
            }
        });
        
        lastNameField.setOnKeyPressed(event -> {
            if (!firstNameField.getText().isEmpty()
                && !lastNameField.getText().isEmpty()
                && !emailField.getText().isEmpty()
                && !passwordField.getText().isEmpty()) {
                registerBtn.setDisable(false);
            } else {
                registerBtn.setDisable(true);
            }
        });
        
        emailField.setOnKeyPressed(event -> {
            if (!firstNameField.getText().isEmpty()
                && !lastNameField.getText().isEmpty()
                && !emailField.getText().isEmpty()
                && !passwordField.getText().isEmpty()) {
                registerBtn.setDisable(false);
            } else {
                registerBtn.setDisable(true);
            }
        });
        
        passwordField.setOnKeyPressed(event -> {
            if (!firstNameField.getText().isEmpty()
                && !lastNameField.getText().isEmpty()
                && !emailField.getText().isEmpty()
                && !passwordField.getText().isEmpty()) {
                registerBtn.setDisable(false);
            } else {
                registerBtn.setDisable(true);
            } 
        });

        registerBtn.setOnAction(event -> {
            String enteredEmail = emailField.getText();
            String enteredPassword = passwordField.getText();

            boolean validEmail = enteredEmail.contains("@")
            && enteredEmail.contains(".");

            boolean hasDigit = false;
            boolean hasLetter = false;

            for (int i = 0; i < enteredPassword.length(); i++) {
                char c = enteredPassword.charAt(i);

                if (Character.isDigit(c)) {
                    hasDigit = true;
                }
                if (Character.isLetter(c)) {
                    hasLetter = true;
                }
            }
            
            if (firstNameField.getText().isEmpty()
                || lastNameField.getText().isEmpty()
                || enteredEmail.isEmpty()
                || enteredPassword.isEmpty()) {                
                statusLabel.setText("Invalid");                
            } else  if (validEmail && hasDigit && hasLetter) {
                statusLabel.setText("Welcome, " + firstNameField.getText());
            } else {
                statusLabel.setText("Invalid email or password.");
            }         
        });
        
        clearBtn.setOnAction(event -> {
            firstNameField.clear();
            lastNameField.clear();
            emailField.clear();
            passwordField.clear();
            statusLabel.setText("");
        });
        
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}