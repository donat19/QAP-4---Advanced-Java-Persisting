import java.util.*;

/**
 * Main class for QAP 4 - Advanced Java: Persisting Data
 * Provides a menu-driven interface for Drug and Patient data management.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== QAP 4 - Advanced Java: Data Persistence ===");
        System.out.println("This application manages Drug and Patient data.");
        System.out.println("Drugs are stored in text files, Patients in PostgreSQL database.\n");

        while (true) {
            displayMenu();
            int choice = getChoice();

            try {
                switch (choice) {
                    case 1:
                        saveDrugToFile();
                        break;
                    case 2:
                        readDrugsFromFile();
                        break;
                    case 3:
                        savePatientToDatabase();
                        break;
                    case 4:
                        readPatientsFromDatabase();
                        break;
                    case 5:
                        testDatabaseConnection();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    /**
     * Displays the main menu
     */
    private static void displayMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Save Drug to text file");
        System.out.println("2. Read all Drugs from text file");
        System.out.println("3. Save Patient to database");
        System.out.println("4. Read all Patients from database");
        System.out.println("5. Test database connection");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Gets user's menu choice with input validation
     * @return validated choice
     */
    private static int getChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Handles saving a Drug to text file
     */
    private static void saveDrugToFile() {
        System.out.println("\n=== Save Drug to File ===");
        
        try {
            System.out.print("Enter Drug ID: ");
            int drugId = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Drug Name: ");
            String drugName = scanner.nextLine();
            
            System.out.print("Enter Drug Cost: ");
            double drugCost = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Dosage: ");
            String dosage = scanner.nextLine();
            
            Drug drug = new Drug(drugId, drugName, drugCost, dosage);
            FileManager.saveDrug(drug);
            
        } catch (Exception e) {
            System.out.println("Error creating drug: " + e.getMessage());
            scanner.nextLine();
        }
    }

    /**
     * Handles reading all Drugs from text file
     */
    private static void readDrugsFromFile() {
        System.out.println("\n=== Read Drugs from File ===");
        
        try {
            List<Drug> drugs = FileManager.readAllDrugs();
            
            if (!drugs.isEmpty()) {
                System.out.println("\nDrug List:");
                System.out.println("ID\tName\t\tCost\tDosage");
                System.out.println("---\t----\t\t----\t------");
                
                for (Drug drug : drugs) {
                    System.out.printf("%d\t%-15s\t$%.2f\t%s%n", 
                        drug.getDrugId(), 
                        drug.getDrugName(), 
                        drug.getDrugCost(), 
                        drug.getDosage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading drugs: " + e.getMessage());
        }
    }

    /**
     * Handles saving a Patient to database
     */
    private static void savePatientToDatabase() {
        System.out.println("\n=== Save Patient to Database ===");
        
        try {
            System.out.print("Enter Patient ID: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            
            Patient patient = new Patient(patientId, firstName, lastName, dob);
            
            DatabaseManager.createTableIfNotExists();
            DatabaseManager.savePatient(patient);
            
        } catch (Exception e) {
            System.out.println("Error saving patient: " + e.getMessage());
            scanner.nextLine();
        }
    }

    /**
     * Handles reading all Patients from database
     */
    private static void readPatientsFromDatabase() {
        System.out.println("\n=== Read Patients from Database ===");
        
        try {
            List<Patient> patients = DatabaseManager.getAllPatients();
            
            if (!patients.isEmpty()) {
                System.out.println("\nPatient List:");
                System.out.println("ID\tFirst Name\tLast Name\tDate of Birth");
                System.out.println("---\t----------\t---------\t-------------");
                
                for (Patient patient : patients) {
                    System.out.printf("%d\t%-12s\t%-12s\t%s%n", 
                        patient.getPatientId(), 
                        patient.getFirstName(), 
                        patient.getLastName(), 
                        patient.getDob());
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading patients: " + e.getMessage());
        }
    }

    /**
     * Tests database connection
     */
    private static void testDatabaseConnection() {
        System.out.println("\n=== Test Database Connection ===");
        DatabaseManager.testConnection();
    }
}
