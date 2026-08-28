/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalab01b;

/**
 *
 * @author patri
 */
public class CourseGrades implements Analyzable{
    private GradedActivity[] grades;
    private static int NUM_GRADES = 4;

    public CourseGrades() {
        this.grades = new GradedActivity[NUM_GRADES];
    }
    
    public void setLab(GradedActivity lab) {
        grades[0] = lab;
    }

    public void setPassFailExam(PassFailExam exam) {
        grades[1] = exam;
    }

    public void setEssay(Essay essay) {
        grades[2] = essay;
    }

    public void setFinalExam(FinalExam exam) {
        grades[3] = exam;
    }

    @Override
    public String toString() {
        return String.format(
        "Lab: %.2f %c\n" +
        "Pass/Fail Exam: %.2f %c\n" +
        "Essay: %.2f %c\n" +
        "Final Exam: %.2f %c",
        grades[0].getScore(), grades[0].getGrade(),
        grades[1].getScore(), grades[1].getGrade(),
        grades[2].getScore(), grades[2].getGrade(),
        grades[3].getScore(), grades[3].getGrade()
        );
    }    

    @Override
    public double getAverage() {
        double total = 0;
        int count = 0;
        for (GradedActivity gradedAcivity : grades) {
            if (gradedAcivity != null) {
                total += gradedAcivity.getScore();
                count++;
            }
        }
        return (count == 0) ? 0.0 : total / count;
    }

    @Override
    public GradedActivity getHighest() {
        GradedActivity highest = grades[0];
        
        for (int i = 1; i < grades.length; i++) {
            if (grades[i].getScore() > highest.getScore()) {
                highest = grades[i];
            }
        }
        return highest;
    }

    @Override
    public GradedActivity getLowest() {
       GradedActivity lowest = grades[0];
       
        for (int i = 1; i < grades.length; i++) {
            if (grades[i].getScore() < lowest.getScore()) {
                lowest = grades[i];
            }
        }
        return lowest;
    }
}
