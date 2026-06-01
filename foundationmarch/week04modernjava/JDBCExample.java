package foundationmarch.week04modernjava;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBCExample adapted to use a separate `clients` table for banking-like examples.
 * DB: dev @ 127.0.0.1:3306, user=root, pass=admin
 * 
 * compile : javac -cp ".;foundationmarch\week04modernjava\mysql-connector-j-9.7.0.jar" foundationmarch\week04modernjava\JDBCExample.java
 * run : java -cp ".;foundationmarch\week04modernjava\mysql-connector-j-9.7.0.jar" foundationmarch.week04modernjava.JDBCExample
 */
public class JDBCExample {

    // Load config from config.properties (if present), then env vars, then defaults
    private static final Properties CONFIG = new Properties();
    static {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            CONFIG.load(fis);
        } catch (IOException ignored) {
            // no config file, will use env vars or defaults
        }
    }

    private static final String DB_URL = CONFIG.getProperty("jdbc.url",
            System.getenv().getOrDefault("JDBC_DB_URL", "jdbc:mysql://127.0.0.1:3306/dev"));
    private static final String DB_USER = CONFIG.getProperty("jdbc.user",
            System.getenv().getOrDefault("JDBC_DB_USER", "root"));
    private static final String DB_PASSWORD = CONFIG.getProperty("jdbc.password",
            System.getenv().getOrDefault("JDBC_DB_PASSWORD", "admin"));

    public static void main(String[] args) {
        System.out.println("===== JDBC (clients) EXAMPLES =====\n");

        // Create table if not exists
        createClientsTable();

        // CRUD operations
        System.out.println("\n1. INSERT (Create):");
        insertClients();

        System.out.println("\n2. SELECT (Read):");
        readAllClients();

        // System.out.println("\n3. UPDATE (balance):");
        // updateClientBalance(1, 1200.50);

        // System.out.println("\n4. DELETE:");
        // deleteClient(4);

        // System.out.println("\n5. QUERY with Filtering:");
        // queryClientsWithMinBalance(1000.0);

        // System.out.println("\n6. TRANSACTION (transfer) demo:");
        // transferFunds("ACC1001", "ACC1002", 200.0);

        // System.out.println("\n===== JDBC CLIENTS EXAMPLES COMPLETED =====");
    }

    // ===== CREATE TABLE =====
    static void createClientsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS clients (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100) NOT NULL, " +
                "account_no VARCHAR(32) NOT NULL UNIQUE, " +
                "balance DECIMAL(12,2) NOT NULL DEFAULT 0, " +
                "status VARCHAR(20) DEFAULT 'ACTIVE', " +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ")";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Table 'clients' created/verified successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating clients table: " + e.getMessage());
        }
    }

    // ===== INSERT (Create) =====
    static void insertClients() {
        String sql = "INSERT INTO clients (name, account_no, balance, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Alice Bank");
            pstmt.setString(2, "ACC1001");
            pstmt.setDouble(3, 1500.00);
            pstmt.setString(4, "ACTIVE");
            pstmt.executeUpdate();

            pstmt.setString(1, "Bob Money");
            pstmt.setString(2, "ACC1002");
            pstmt.setDouble(3, 800.00);
            pstmt.setString(4, "ACTIVE");
            pstmt.executeUpdate();

            pstmt.setString(1, "Charlie Cash");
            pstmt.setString(2, "ACC1003");
            pstmt.setDouble(3, 2200.75);
            pstmt.setString(4, "ACTIVE");
            pstmt.executeUpdate();

            pstmt.setString(1, "Diana Deposit");
            pstmt.setString(2, "ACC1004");
            pstmt.setDouble(3, 50.00);
            pstmt.setString(4, "INACTIVE");
            pstmt.executeUpdate();

            System.out.println("✓ Inserted sample clients");
        } catch (SQLException e) {
            System.out.println("Error inserting clients: " + e.getMessage());
        }
    }

    // ===== SELECT (Read) =====
    static void readAllClients() {
        String sql = "SELECT id, name, account_no, balance, status, created_at FROM clients";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("All clients:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String acc = rs.getString("account_no");
                double bal = rs.getDouble("balance");
                String status = rs.getString("status");
                Timestamp created = rs.getTimestamp("created_at");
                System.out.printf("  ID: %d, %s (%s), balance=%.2f, status=%s, created=%s\n", id, name, acc, bal, status, created);
            }
        } catch (SQLException e) {
            System.out.println("Error reading clients: " + e.getMessage());
        }
    }

    // ===== UPDATE =====
    static void updateClientBalance(int id, double newBalance) {
        String sql = "UPDATE clients SET balance = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("✓ Updated client ID " + id + " with new balance: " + newBalance);
            } else {
                System.out.println("✗ Client ID " + id + " not found");
            }
        } catch (SQLException e) {
            System.out.println("Error updating client: " + e.getMessage());
        }
    }

    // ===== DELETE =====
    static void deleteClient(int id) {
        String sql = "DELETE FROM clients WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("✓ Deleted client ID " + id);
            } else {
                System.out.println("✗ Client ID " + id + " not found");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting client: " + e.getMessage());
        }
    }

    // ===== QUERY WITH FILTER & AGGREGATION =====
    static void queryClientsWithMinBalance(double minBalance) {
        String sql = "SELECT name, account_no, balance FROM clients WHERE balance > ? ORDER BY balance DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, minBalance);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Clients with balance > " + minBalance + ":");
                while (rs.next()) {
                    String name = rs.getString("name");
                    String acc = rs.getString("account_no");
                    double bal = rs.getDouble("balance");
                    System.out.printf("  - %s (%s): %.2f\n", name, acc, bal);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error querying clients: " + e.getMessage());
        }
    }

    // ===== HELPER: Get Average Balance =====
    static void getAverageBalance() {
        String sql = "SELECT AVG(balance) as average FROM clients";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                double avg = rs.getDouble("average");
                System.out.printf("Average balance: %.2f\n", avg);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ===== HELPER: Transaction Example (funds transfer) =====
    static void transferFunds(String fromAccount, String toAccount, double amount) {
        String withdraw = "UPDATE clients SET balance = balance - ? WHERE account_no = ?";
        String deposit = "UPDATE clients SET balance = balance + ? WHERE account_no = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            conn.setAutoCommit(false);  // Start transaction

            try (PreparedStatement pWithdraw = conn.prepareStatement(withdraw);
                 PreparedStatement pDeposit = conn.prepareStatement(deposit)) {

                // Withdraw
                pWithdraw.setDouble(1, amount);
                pWithdraw.setString(2, fromAccount);
                int w = pWithdraw.executeUpdate();

                // Simulate potential problem: insufficient funds check
                if (w == 0) throw new SQLException("From account not found or insufficient rows updated");

                // Deposit
                pDeposit.setDouble(1, amount);
                pDeposit.setString(2, toAccount);
                int d = pDeposit.executeUpdate();

                if (d == 0) throw new SQLException("To account not found");

                conn.commit();
                System.out.printf("✓ Transferred %.2f from %s to %s\n", amount, fromAccount, toAccount);
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("✗ Transfer failed, rolled back: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error in transferFunds: " + e.getMessage());
        }
    }
}

    /*
     * IMPORTANT JDBC NOTES:
     * 1. Use PreparedStatement for parameters to prevent SQL injection.
     * 2. Use try-with-resources to auto-close Connection/Statement/ResultSet.
     * 3. Use conn.setAutoCommit(false)/commit()/rollback() for transactions.
     * 
     * 
     * Approach 1: VS Code (No CLI)
     * 
     * Install the Extension Pack for Java.
     * Open the week4 folder in VS Code.
     * Create a folder named lib:
     * week4/
     * ├── JDBCExample.java
     * └── lib/
     *      └── mysql-connector-j-9.7.0.jar
     * VS Code should detect the JAR automatically under Referenced Libraries.
     * If not, open the Java Projects panel and add the JAR manually.
     * Run
     * Open JDBCExample.java.
     * Click the ▶ Run button above the main() method.
     * Or right-click inside the file → Run Java.
     * No javac or java commands needed.
     * 
     * 
     * Approach 2: Command Line (CLI)
     * Open Command Prompt
     * Navigate to your folder:
     * cd path\to\FoundationMarch\week4
     * Example:
     * cd C:\Users\YourName\FoundationMarch\week4
     * 
     * Compile
     * Windows: javac -cp ".;mysql-connector-j-9.7.0.jar" JDBCExample.java
     * This creates:
     * JDBCExample.class
     * Run
     * Windows: java -cp ".;mysql-connector-j-9.7.0.jar" JDBCExample
     */


