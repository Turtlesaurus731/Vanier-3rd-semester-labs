/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab01;

/**
 *
 * @author patrick (2584955)
 */
public class ZipCode {
    protected int Zip;
    
    public ZipCode(int zip){
        String s = Integer.toString(zip);
        if (s.length() <= 5) {
            this.Zip = zip;
        } else {
            System.out.print("Error, Zipcode is more than 5 integers\n");
        }
    }
        
    public ZipCode(String barCode) {
        this.Zip = parseBarCode(barCode);
    }
   
    /**
     * Converts and gets the bar code from the zip code
     * @return the converted zip code as a bar code
     */
    public String GetBarCode(){
        String s = String.format("%05d", Zip);
        String barcode = "";
        for (int i = 0; i < 5; i++) {
           switch(s.charAt(i)) {
                case '0' -> barcode += "11000"; 
                case '1' -> barcode += "00011";
                case '2' -> barcode += "00101";
                case '3' -> barcode += "00110";
                case '4' -> barcode += "01001";
                case '5' -> barcode += "01010";
                case '6' -> barcode += "01100";
                case '7' -> barcode += "10001";
                case '8' -> barcode += "10010";
                case '9' -> barcode += "10100";
           }
        }
        return 1 + barcode + 1;
    }
    
    /**
     * Converts bar code's binary string to a Zip code
     * @param binary input binary string that is to be converted
     * @return the converted binary as a Zip code
     */
    private int parseBarCode(String binary) {
        
        if (binary.length() != 27) {
            System.out.print("Error, not a barcode");
            return -1;
        } else if (binary.charAt(0) != '1' || binary.charAt(26) != '1') { 
            System.out.print("Error, not a barcode");
            return -1;
        }
        
        for (char c : binary.toCharArray()) {
            if (c != '1' && c != '0') {
            System.out.print("Error, not a barcode");
            return -1;    
            }
        }
        
        String readBarcode = binary.substring(1,26);
        String[] binaryGroups = {"0","0","0","0","0"};
        int min = 0;
        int max = 5;
        
        for (int i = 0; i < 5; i++) {
            binaryGroups[i] = readBarcode.substring(min,max);
            max += 5;
            min += 5;
        }
        
        String zipCode = "";
        
        for (int i = 0; i < 5; i++){
            int count1 = 0;
            for (char c : binaryGroups[i].toCharArray()) {
                if (c == '1') {
                count1++;
                }
            }
            
            if (count1 != 2) {
                System.out.println(String.
                        format("%s has invlalid sequence in the bar code"
                                , binaryGroups[i]));
                return -1;
            }
            
            switch(binaryGroups[i]) {
                case "11000" -> binaryGroups[i] = "0"; 
                case "00011" -> binaryGroups[i] = "1";
                case "00101" -> binaryGroups[i] = "2";
                case "00110" -> binaryGroups[i] = "3";
                case "01001" -> binaryGroups[i] = "4";
                case "01010" -> binaryGroups[i] = "5";
                case "01100" -> binaryGroups[i] = "6";
                case "10001" -> binaryGroups[i] = "7";
                case "10010" -> binaryGroups[i] = "8";
                case "10100" -> binaryGroups[i] = "9";
                
            }
            zipCode = zipCode + binaryGroups[i];
        }
        return Integer.parseInt(zipCode); 
    }
}
