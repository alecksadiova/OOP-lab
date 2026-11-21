package com.mycompany.m6a1_adiova;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    public static void main(String[] args) {

        Map<String, String> students = new HashMap<>();

        students.put("2026-001", "Ana Cruz");
        students.put("2026-002", "Ben Lim");
        students.put("2026-003", "Cara Reyes");

        System.out.println("=== Student ID Registry ===");

        System.out.println("\nTest 1: Duplicate ID");

        if (students.containsKey("2026-002")) {
            System.out.println("Duplicate ID rejected: 2026-002");
        } else {
            students.put("2026-002", "Another Student");
        }

        System.out.println("2026-002: " + students.get("2026-002"));

        System.out.println("\nTest 2: Student Lookup");

        String[] searchIds = {"2026-003", "2026-999"};

        for (String id : searchIds) {
            if (students.containsKey(id)) {
                System.out.println(id + ": " + students.get(id));
            } else {
                System.out.println(id + ": Student not found");
            }
        }

        System.out.println("\n=== All Accepted Students ===");

        for (Map.Entry<String, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
