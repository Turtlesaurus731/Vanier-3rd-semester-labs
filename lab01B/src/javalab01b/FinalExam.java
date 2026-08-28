/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab01b;

/**
 *
 * @author patrick (2584955)
 */
public class FinalExam extends GradedActivity {
    private int numOfQuestions;
    private double pointsEach;
    private int numMissed;


    public FinalExam(int numOfQuestions, int numMissed) {
        this.numOfQuestions = numOfQuestions;
        this.numMissed = numMissed;
        this.pointsEach = 100.0 / numOfQuestions;
        setScore(100.0 - (numMissed * pointsEach));
    }

    public double getPointsEach() {
        return pointsEach;
    }

    public int getNumMissed() {
        return numMissed;
    }
    
}
