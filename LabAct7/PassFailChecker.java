package com.mycompany.m7a2_adiova;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;

public class PassFailChecker {

    public static String evaluateScore(int score) {
        if (score < 0 || score > 100) {
            return "Invalid score";
        } else if (score >= 75) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }

    public static void createGUI() {

        JFrame frame = new JFrame("Pass/Fail Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel prompt = new JLabel("Enter Score (0-100):");
        JTextField scoreField = new JTextField(10);
        JButton checkButton = new JButton("Check Result");
        JLabel resultLabel = new JLabel("Result: ");

        JPanel inputPanel = new JPanel();
        inputPanel.add(prompt);
        inputPanel.add(scoreField);

        panel.add(inputPanel);
        panel.add(checkButton);
        panel.add(resultLabel);

        checkButton.addActionListener(e -> {
            String input = scoreField.getText().trim();

            if (input.isEmpty()) {
                resultLabel.setText("Result: Invalid score");
                return;
            }

            try {
                int score = Integer.parseInt(input);
                resultLabel.setText("Result: " + evaluateScore(score));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Result: Invalid score");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createGUI());
    }
}
