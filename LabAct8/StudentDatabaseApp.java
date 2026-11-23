package com.mycompany.m8a2_adiova;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentDatabaseApp {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/lab8_student_db";

    private JTextField idField;
    private JTextField nameField;
    private JTextField programField;
    private JTextArea resultArea;

    private static Connection getConnection() throws SQLException {
        String user = System.getenv("LAB8_DB_USER");
        String password = System.getenv("LAB8_DB_PASSWORD");

        if (user == null || password == null) {
            throw new SQLException("Database credentials are not configured.");
        }

        return DriverManager.getConnection(URL, user, password);
    }

    private static int validateId(String text) {
        int id = Integer.parseInt(text.trim());

        if (id <= 0) {
            throw new NumberFormatException("ID must be positive.");
        }

        return id;
    }

    private static void addStudent(int id, String name, String program)
            throws SQLException {

        String sql = "INSERT INTO students (id, name, program) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, program);
            stmt.executeUpdate();
        }
    }

    private static String findStudent(int id) throws SQLException {
        String sql = "SELECT id, name, program FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return "Found: " + rs.getInt("id") + " - "
                            + rs.getString("name") + " - "
                            + rs.getString("program");
                }
            }
        }

        return "Not found";
    }

    private void handleAdd() {
        int id;

        try {
            id = validateId(idField.getText());
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid ID. Enter a positive number.");
            return;
        }

        String name = nameField.getText().trim();
        String program = programField.getText().trim();

        if (name.isEmpty() || program.isEmpty()) {
            resultArea.setText("Validation error: Name and program are required.");
            return;
        }

        try {
            addStudent(id, name, program);
            resultArea.setText("Saved: " + id + " - " + name + " - " + program);
        } catch (SQLException e) {
            if ("23000".equals(e.getSQLState())) {
                resultArea.setText("Duplicate ID: " + id);
            } else {
                resultArea.setText("Database error: " + e.getMessage());
            }
        }
    }

    private void handleSearch() {
        int id;

        try {
            id = validateId(idField.getText());
        } catch (NumberFormatException e) {
            resultArea.setText("Invalid ID. Enter a positive number.");
            return;
        }

        try {
            resultArea.setText(findStudent(id));
        } catch (SQLException e) {
            resultArea.setText("Database error: " + e.getMessage());
        }
    }

    private void createGUI() {
        JFrame frame = new JFrame("Student Add-and-Search Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel fields = new JPanel(new GridLayout(3, 2, 8, 8));
        fields.add(new JLabel("Student ID:"));
        idField = new JTextField(15);
        fields.add(idField);

        fields.add(new JLabel("Student Name:"));
        nameField = new JTextField(15);
        fields.add(nameField);

        fields.add(new JLabel("Program:"));
        programField = new JTextField(15);
        fields.add(programField);

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(searchButton);

        resultArea = new JTextArea(4, 30);
        resultArea.setEditable(false);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.add(fields, BorderLayout.NORTH);
        panel.add(buttons, BorderLayout.CENTER);
        panel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        addButton.addActionListener(e -> handleAdd());
        searchButton.addActionListener(e -> handleSearch());

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new StudentDatabaseApp().createGUI());
    }
}
