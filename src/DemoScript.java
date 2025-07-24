/**
 * Quick demo script that shows the application functionality
 * without requiring user input - useful for demonstrations
 */
public class DemoScript {
    
    public static void main(String[] args) {
        System.out.println("=== QAP 4 - Automated Demo ===");
        System.out.println("Demonstrating all functionality without user interaction\n");
        
        try {
            demonstrateFileOperations();
            demonstrateDatabaseOperations();
            
            System.out.println("🎉 Demo completed successfully!");
            System.out.println("Run 'java Main' for interactive mode");
            
        } catch (Exception e) {
            System.out.println("Demo error: " + e.getMessage());
            System.out.println("This may be due to database configuration.");
        }
    }
    
    private static void demonstrateFileOperations() throws Exception {
        System.out.println("=== File Operations Demo ===");
        
        cleanupDemoFiles();
        
        Drug drug1 = new Drug(201, "DemoAspirin", 10.99, "325mg");
        Drug drug2 = new Drug(202, "DemoIbuprofen", 8.50, "200mg");
        Drug drug3 = new Drug(203, "DemoAcetaminophen", 12.25, "500mg");
        
        System.out.println("Saving demo drugs to file...");
        FileManager.saveDrug(drug1);
        FileManager.saveDrug(drug2);
        FileManager.saveDrug(drug3);
        
        System.out.println("Reading drugs from file:");
        var drugs = FileManager.readAllDrugs();
        
        System.out.println("ID\tName\t\t\tCost\tDosage");
        System.out.println("---\t----\t\t\t----\t------");
        for (Drug drug : drugs) {
            System.out.printf("%d\t%-20s\t$%.2f\t%s%n", 
                drug.getDrugId(), 
                drug.getDrugName(), 
                drug.getDrugCost(), 
                drug.getDosage());
        }
        System.out.println();
    }
    
    /**
     * Clean up demo files to start fresh
     */
    private static void cleanupDemoFiles() {
        try {
            java.io.File drugFile = new java.io.File("drug_data.txt");
            if (drugFile.exists()) {
                drugFile.delete();
                System.out.println("Cleaned up previous drug data file.");
            }
        } catch (Exception e) {
        }
    }
    
    private static void demonstrateDatabaseOperations() {
        System.out.println("=== Database Operations Demo ===");
        
        try {
            System.out.println("Testing database connection...");
            boolean connected = DatabaseManager.testConnection();
            
            if (!connected) {
                System.out.println("⚠️  Database not available - skipping database demo");
                System.out.println("Please configure PostgreSQL and update DatabaseManager.java");
                return;
            }
            
            DatabaseManager.createTableIfNotExists();
            
            cleanupDemoData();
            
            Patient patient1 = new Patient(301, "Alice", "Johnson", "1988-03-15");
            Patient patient2 = new Patient(302, "Bob", "Williams", "1975-11-22");
            Patient patient3 = new Patient(303, "Carol", "Davis", "1993-07-08");
            
            System.out.println("Saving demo patients to database...");
            DatabaseManager.savePatient(patient1);
            DatabaseManager.savePatient(patient2);
            DatabaseManager.savePatient(patient3);
            
            System.out.println("Reading patients from database:");
            var patients = DatabaseManager.getAllPatients();
            
            System.out.println("ID\tFirst Name\tLast Name\tDate of Birth");
            System.out.println("---\t----------\t---------\t-------------");
            for (Patient patient : patients) {
                System.out.printf("%d\t%-12s\t%-12s\t%s%n", 
                    patient.getPatientId(), 
                    patient.getFirstName(), 
                    patient.getLastName(), 
                    patient.getDob());
            }
            
        } catch (Exception e) {
            System.out.println("⚠️  Database demo failed: " + e.getMessage());
            System.out.println("This is normal if PostgreSQL is not configured yet.");
        }
        
        System.out.println();
    }
    
    /**
     * Clean up demo data to avoid duplicates on repeated runs
     */
    private static void cleanupDemoData() {
        try {
            java.sql.Connection conn = java.sql.DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/qap4_database", "postgres", "postgres");
            java.sql.PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM patients WHERE id BETWEEN 301 AND 303");
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            System.out.println("Cleaned up previous demo data.");
        } catch (Exception e) {
        }
    }
}
