package com.mycompany.m3a1_adiova;

public class StudentProfileDemo {
    public static void main(String[] args) {
        StudentProfile student1 = new StudentProfile("S001", "Ana", 85);
        StudentProfile student2 = new StudentProfile("S002", "Ben", 90);

        System.out.println("=== Student Profiles ===");
        student1.displayProfile();
        System.out.println();
        student2.displayProfile();

        System.out.println("\nValid Score Update:");
        student1.setQuizScore(95);
        student1.displayProfile();

        System.out.println("\nInvalid Score Update:");
        student2.setQuizScore(120);
        student2.displayProfile();

        System.out.println("\nTotal Students: " + StudentProfile.getStudentCount());
    }
}
