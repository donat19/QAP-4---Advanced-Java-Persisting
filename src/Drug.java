/**
 * Drug class representing a pharmaceutical drug with ID, name, cost, and dosage.
 * Supports serialization to and from string format for file storage.
 */
public class Drug {
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    /**
     * Constructor for Drug
     * @param drugId unique identifier for the drug
     * @param drugName name of the drug
     * @param drugCost cost of the drug
     * @param dosage dosage information
     */
    public Drug(int drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    /**
     * Converts Drug object to CSV string format for file storage
     * @return CSV string representation
     */
    @Override
    public String toString() {
        return drugId + "," + drugName + "," + drugCost + "," + dosage;
    }

    /**
     * Creates Drug object from CSV string
     * @param line CSV string containing drug data
     * @return Drug object
     */
    public static Drug fromString(String line) {
        String[] parts = line.split(",");
        return new Drug(
            Integer.parseInt(parts[0]), 
            parts[1], 
            Double.parseDouble(parts[2]), 
            parts[3]
        );
    }

    // Getters
    public int getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public double getDrugCost() {
        return drugCost;
    }

    public String getDosage() {
        return dosage;
    }

    // Setters
    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public void setDrugCost(double drugCost) {
        this.drugCost = drugCost;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
