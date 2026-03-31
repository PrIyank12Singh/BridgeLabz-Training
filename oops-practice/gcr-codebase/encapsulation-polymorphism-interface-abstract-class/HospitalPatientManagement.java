import java.util.*;

// interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// abstract Class
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // Sensitive data using Encapsulation
    private String diagnosis;
    private List<String> medicalHistory = new ArrayList<>();

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Controlled access to sensitive data
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    protected void addHistory(String record) {
        medicalHistory.add(record);
    }

    protected void showHistory() {
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
        setDiagnosis("Admitted for treatment");
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        addHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        showHistory();
    }
}

// OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
        setDiagnosis("Consultation");
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        showHistory();
    }
}

// Main Class
public class HospitalPatientManagement {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        Patient p1 = new InPatient(01, "Deepak", 22, 5, 3000);
        Patient p2 = new OutPatient(02, "Deepika", 16, 800);

        patients.add(p1);
        patients.add(p2);

        // polymorphism
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Total Bill: " + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.addRecord("Initial diagnosis done");
                mr.viewRecords();
            }

            System.out.println();
        }
    }
}
