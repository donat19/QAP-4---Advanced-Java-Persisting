import java.io.*;
import java.util.*;

/**
 * FileManager handles file operations for Drug objects.
 * Provides functionality to save and read Drug objects from text file.
 */
public class FileManager {
    private static final String FILE_PATH = "drug_data.txt";

    /**
     * Saves a Drug object to the text file
     * @param drug Drug object to save
     * @throws IOException if file operations fail
     */
    public static void saveDrug(Drug drug) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(drug.toString());
            writer.newLine();
            System.out.println("Drug saved successfully to " + FILE_PATH);
        }
    }

    /**
     * Reads all Drug objects from the text file
     * @return List of Drug objects
     * @throws IOException if file operations fail
     */
    public static List<Drug> readAllDrugs() throws IOException {
        List<Drug> drugs = new ArrayList<>();
        File file = new File(FILE_PATH);
        
        if (!file.exists()) {
            System.out.println("No drug data file found. File will be created when first drug is saved.");
            return drugs;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        drugs.add(Drug.fromString(line));
                    } catch (Exception e) {
                        System.out.println("Error parsing line: " + line + " - " + e.getMessage());
                    }
                }
            }
        }
        
        if (drugs.isEmpty()) {
            System.out.println("No drugs found in the file.");
        } else {
            System.out.println("Found " + drugs.size() + " drug(s) in the file:");
        }
        
        return drugs;
    }

    /**
     * Checks if the drug data file exists
     * @return true if file exists, false otherwise
     */
    public static boolean fileExists() {
        return new File(FILE_PATH).exists();
    }
}
