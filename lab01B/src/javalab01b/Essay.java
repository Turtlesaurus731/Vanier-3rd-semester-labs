/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab01b;

/**
 *
 * @author patri
 */
public class Essay extends GradedActivity{
    private double grammar;
    private double spelling;
    private double correctLength;
    private double content;

    public Essay() {
        this.grammar = grammar;
        this.spelling = spelling;
        this.correctLength = correctLength;
        this.content = content;
    }
    
    public void setScore(double grammar, double spelling, double correctLength,
            double content) {
        
        double score = grammar + spelling + correctLength + content;
        super.setScore(score);
    }
    
    public void setGrammer(double grammar) {
        this.grammar = grammar;
    }

    public void setSpelling(double spelling) {
        this.spelling = spelling;
    }

    public void setCorrectLength(double correctLeght) {
        this.correctLength = correctLeght;
    }

    public void setContent(double content) {
        this.content = content;
    }

    public double getGrammar() {
        return grammar;
    }

    public double getSpelling() {
        return spelling;
    }

    public double getCorrectLength() {
        return correctLength;
    }

    public double getScore() {
        return super.getScore();
    }
}
