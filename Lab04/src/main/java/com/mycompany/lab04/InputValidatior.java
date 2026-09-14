/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab04;

import java.util.Map;
import javafx.scene.control.TextField;

/**
 *
 * @author 2584955
 */
public class InputValidatior {
    
    public static boolean validate(Map<String, TextField> userInformation) {
        for (String fieldName: userInformation.keySet()) {
            TextField field = userInformation.get(fieldName);
            String infoToValidate = field.getText().trim();
            
            if (infoToValidate.isEmpty()) {
                System.out.println(fieldName + "is empty");
                return false;
            }
            
            try {
                if (fieldName.equalsIgnoreCase("Days")) {
                    int days = Integer.valueOf(infoToValidate);
                    
                    if (days <= 0) {
                        System.out.println(fieldName + "is not greater than 0");
                        return false;
                    }
                } else {
                    double amount = Double.valueOf(infoToValidate);
                    
                    if (amount < 0) {
                        System.out.println(fieldName + " can't be negative");
                        return false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(fieldName + " is invalid");
                return false;
            }
        }
        return true;
    }
}
