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
            String infoToValidate = field.getText();
            infoToValidate.trim();
            
            try {
                if (fieldName.equalsIgnoreCase("Days")) {
                    Integer.valueOf(infoToValidate);
                } else {
                    Double.valueOf(infoToValidate);
                }
            } catch (NumberFormatException e) {
                System.out.println(fieldName + " is invalid");
                return false;
            }
        }
        return true;
    }
}
