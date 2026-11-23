package com.mycompany.m8a1_adiova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCrudConsole {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/lab8_student_db";

    private static Connection getConnection()
            throws SQLException {

        String user = System.getenv("LAB8_DB_USER");
        String password = System.getenv("LAB8_DB_PASSWORD");

        if (user == null || password == null) {
            throw new SQLException(
                    "Set LAB8_DB_USER and LAB8_DB_PASSWORD first.");
        }

        return DriverManager.getConnection(URL, user, password);
    }

    public static void addStudent(int id, String name, String program)
            throws SQLException {

        String sql = "INSERT INTO students (id, name, program) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, program);

            int rows = stmt.executeUpdate();
            System.out.println("Add: " + rows + " row added");
        }
    }

    public static void findStudent(int id) throws SQLException {

        String sql = "SELECT id, name, program FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    System.out.println(rs.getInt("id") + " - "
                            + rs.getString("name") + " - "
                            + rs.getString("program"));
                } else {
                    System.out.println("Not found");
                }
            }
        }
    }

    public static void updateProgram(int id, String program)
            throws SQLException {

        String sql = "UPDATE students SET program = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, program);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
            System.out.println("Update: " + rows + " row updated");
        }
    }

    public static void deleteStudent(int id) throws SQLException {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println("Delete: " + rows + " row deleted");
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Student CRUD Console ===");

        try {
            // Remove the record if it already exists
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "DELETE FROM students WHERE id = ?")) {

                stmt.setInt(1, 108);
                stmt.executeUpdate();
            }

            addStudent(108, "Ana Cruz", "BSIT");

            System.out.println("\nFirst Search:");
            findStudent(108);

            updateProgram(108, "BSCS");

            System.out.println("\nSecond Search:");
            findStudent(108);

            deleteStudent(108);

            System.out.println("\nFinal Search:");
            findStudent(108);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
