/**
 * Patient class representing a patient with ID, name, and date of birth.
 * Designed to work with PostgreSQL database storage.
 */
public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private String dob; // Date of birth in YYYY-MM-DD format

    /**
     * Constructor for Patient
     * @param patientId unique identifier for the patient
     * @param firstName patient's first name
     * @param lastName patient's last name
     * @param dob date of birth in YYYY-MM-DD format
     */
    public Patient(int patientId, String firstName, String lastName, String dob) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    /**
     * String representation of Patient
     * @return formatted string with patient information
     */
    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + firstName + " " + lastName + ", DOB: " + dob;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    // Setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
