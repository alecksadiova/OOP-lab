package com.mycompany.m5a1_adiova;

public class ScoreRecovery {

    public static void evaluateScore(String scoreText)
            throws InvalidScoreException {

        int score = Integer.parseInt(scoreText);

        if (score < 0 || score > 100) {
            throw new InvalidScoreException(
                    "Invalid score! Score must be 0 to 100.");
        }

        if (score >= 75) {
            System.out.println(score + " - PASSED");
        } else {
            System.out.println(score + " - FAILED");
        }
    }

    public static void main(String[] args) {

        String[] scores = {"85", "abc", "105"};

        System.out.println("=== Student Score Recovery ===");

        for (String scoreText : scores) {

            System.out.println("\nProcessing score: " + scoreText);

            try {
                evaluateScore(scoreText);

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input! Please enter a numeric score.");

            } catch (InvalidScoreException e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Validation attempt completed");
            }
        }
    }
}
