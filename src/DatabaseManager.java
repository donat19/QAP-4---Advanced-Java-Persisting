import java.sql.*;
import java.util.*;

/**
 * DatabaseManager handles database operations for Patient objects.
 * Provides functionality to save and retrieve Patient objects from PostgreSQL database.
 */
public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/qap4_database";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    /**
     * Saves a Patient object to the database
     * @param patient Patient object to save
     * @throws SQLException if database operations fail
     */
    public static void savePatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients (id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getFirstName());
            stmt.setString(3, patient.getLastName());
            
            try {
                java.sql.Date sqlDate = java.sql.Date.valueOf(patient.getDob());
                stmt.setDate(4, sqlDate);
            } catch (IllegalArgumentException e) {
                throw new SQLException("Invalid date format. Expected YYYY-MM-DD, got: " + patient.getDob());
            }
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Patient saved successfully to database!");
            }
        } catch (SQLException e) {
            System.out.println("Error saving patient: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Retrieves all Patient objects from the database
     * @return List of Patient objects
     * @throws SQLException if database operations fail
     */
    public static List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients ORDER BY id";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("dob");
                String dobString = sqlDate.toString();
                
                Patient patient = new Patient(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    dobString
                );
                patients.add(patient);
            }
            
            if (patients.isEmpty()) {
                System.out.println("No patients found in the database.");
            } else {
                System.out.println("Found " + patients.size() + " patient(s) in the database:");
            }
            
        } catch (SQLException e) {
            System.out.println("Error retrieving patients: " + e.getMessage());
            throw e;
        }
        
        return patients;
    }

    /**
     * Tests the database connection
     * @return true if connection successful, false otherwise
     */
    public static boolean testConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Database connection successful!");
            return true;
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            System.out.println("Please check your database configuration in DatabaseManager.java");
            return false;
        }
    }

    /**
     * Creates the patients table if it doesn't exist
     * @throws SQLException if database operations fail
     */
    public static void createTableIfNotExists() throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS patients (" +
                "id INT PRIMARY KEY, " +
                "first_name VARCHAR(50) NOT NULL, " +
                "last_name VARCHAR(50) NOT NULL, " +
                "dob DATE NOT NULL" +
                ")";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(createTableQuery);
            System.out.println("Patients table is ready.");
        }
    }
}
