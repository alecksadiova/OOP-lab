
package com.mycompany.m3a1_aaadiova;

public class StudentProfile {

    private String studentId;
    private String studentName;
    private int quizScore;
    private static int studentCount = 0;

    public StudentProfile(String studentId, String studentName, int quizScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.quizScore = 0;
        setQuizScore(quizScore);
        studentCount++;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public void setQuizScore(int score) {
        if (score >= 0 && score <= 100) {
            quizScore = score;
        } else {
            System.out.println("Invalid score! Must be 0 to 100.");
        }
    }

    public void displayProfile() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Quiz Score: " + quizScore);
    }
}
