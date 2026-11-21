package com.mycompany.m6a2_adiova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreListAnalyzer {

    public static void main(String[] args) {

        List<Integer> scores = new ArrayList<>();

        scores.add(88);
        scores.add(72);
        scores.add(95);
        scores.add(81);
        scores.add(72);

        System.out.println("=== Score List Analyzer ===");

        System.out.println("\nOriginal Scores: " + scores);

        int total = 0;

        for (int score : scores) {
            total += score;
        }

        double average = (double) total / scores.size();

        System.out.println("Average Score: " + average);

        Collections.sort(scores);

        System.out.println("\nSorted Scores: " + scores);

        System.out.println("\nTest 1: Search for 81");

        int index81 = Collections.binarySearch(scores, 81);

        if (index81 >= 0) {
            System.out.println("81 Found at index " + index81);
        } else {
            System.out.println("81 Not found");
        }

        System.out.println("\nTest 2: Search for 100");

        int index100 = Collections.binarySearch(scores, 100);

        if (index100 >= 0) {
            System.out.println("100 Found at index " + index100);
        } else {
            System.out.println("100 Not found");
        }
    }
}
