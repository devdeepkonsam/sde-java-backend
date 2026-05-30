package foundationmarch.week04modernjava;

import java.sql.*;

/**
 * JDBC (Java Database Connectivity) Example
 * Connect to MySQL database and perform CRUD operations
 * Prerequisites:
 * 1. MySQL server running
 * 2. Add mysql-connector-java dependency (e.g., mysql:mysql-connector-java:8.0.33)
 * 3. Create database: CREATE DATABASE student_db;
 * 4. Create table (see below)
 */
public class JDBCExample {

    // Database configuration
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "your_password";  // Change this
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        System.out.println("===== JDBC EXAMPLES =====\n");

        // Create table if not exists
        createTable();

        // CRUD operations
        System.out.println("\n1. INSERT (Create):");
        insertStudents();

        System.out.println("\n2. SELECT (Read):");
        readAllStudents();

        System.out.println("\n3. UPDATE:");
        updateStudent(1, 95);

        System.out.println("\n4. DELETE:");
        deleteStudent(3);

        System.out.println("\n5. QUERY with Filtering:");
        queryStudentsWithFilter();

        System.out.println("\n===== JDBC EXAMPLES COMPLETED =====");
    }

    // ===== CREATE TABLE =====
    static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(100) NOT NULL," +
                "score INT NOT NULL," +
                "grade VARCHAR(1))";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'students' created/verified successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // ===== INSERT (Create) =====
    static void insertStudents() {
        String sql = "INSERT INTO students (name, score, grade) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Insert 5 students
            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 85);
            pstmt.setString(3, "A");
            pstmt.executeUpdate();

            pstmt.setString(1, "Bob");
            pstmt.setInt(2, 72);
            pstmt.setString(3, "B");
            pstmt.executeUpdate();

            pstmt.setString(1, "Charlie");
            pstmt.setInt(2, 90);
            pstmt.setString(3, "A");
            pstmt.executeUpdate();

            pstmt.setString(1, "Diana");
            pstmt.setInt(2, 65);
            pstmt.setString(3, "C");
            pstmt.executeUpdate();

            System.out.println("✓ Inserted 4 students");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    // ===== SELECT (Read) =====
    static void readAllStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("All students:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int score = rs.getInt("score");
                String grade = rs.getString("grade");
                System.out.printf("  ID: %d, Name: %s, Score: %d, Grade: %s\n", id, name, score, grade);
            }
        } catch (SQLException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }

    // ===== UPDATE =====
    static void updateStudent(int id, int newScore) {
        String sql = "UPDATE students SET score = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newScore);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✓ Updated student ID " + id + " with new score: " + newScore);
            } else {
                System.out.println("✗ Student ID " + id + " not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
    }

    // ===== DELETE =====
    static void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("✓ Deleted student ID " + id);
            } else {
                System.out.println("✗ Student ID " + id + " not found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting data: " + e.getMessage());
        }
    }

    // ===== QUERY WITH FILTER & AGGREGATION =====
    static void queryStudentsWithFilter() {
        String sql = "SELECT * FROM students WHERE score > ? ORDER BY score DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 70);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Students with score > 70:");
                while (rs.next()) {
                    String name = rs.getString("name");
                    int score = rs.getInt("score");
                    System.out.printf("  - %s: %d\n", name, score);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying data: " + e.getMessage());
        }
    }

    // ===== HELPER: Get Average Score =====
    static void getAverageScore() {
        String sql = "SELECT AVG(score) as average FROM students";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                double avg = rs.getDouble("average");
                System.out.printf("Average score: %.2f\n", avg);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== HELPER: Transaction Example =====
    static void transactionExample() {
        String sql1 = "UPDATE students SET score = score - 5 WHERE name = ?";
        String sql2 = "UPDATE students SET score = score + 5 WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);  // Start transaction

            try (PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                 PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {

                pstmt1.setString(1, "Alice");
                pstmt1.executeUpdate();

                pstmt2.setString(1, "Bob");
                pstmt2.executeUpdate();

                conn.commit();  // Commit all changes
                System.out.println("✓ Transaction completed successfully");
            } catch (SQLException e) {
                conn.rollback();  // Undo all changes on error
                System.out.println("✗ Transaction rolled back: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * IMPORTANT JDBC NOTES:
     * 
     * 1. Always use PreparedStatement for user input (prevents SQL injection)
     * 2. Use try-with-resources to auto-close Connection, Statement, ResultSet
     * 3. Set Connection.setAutoCommit(false) for transactions, then conn.commit()
     * 4. Call conn.rollback() if error occurs during transaction
     * 5. Use ? placeholders in SQL queries, then pstmt.setXXX() to bind values
     * 6. ResultSet.next() returns true if row exists, false if no more rows
     * 7. Use appropriate getters: getInt(), getString(), getDouble(), etc.
     */
}
