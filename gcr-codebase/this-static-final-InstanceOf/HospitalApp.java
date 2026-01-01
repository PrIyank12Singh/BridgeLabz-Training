class Patient {

    // static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // instance variables
    String name;
    int age;
    String ailment;

    // final variable
    final String patientID;

    // constructor using this
    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // static method
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // display details using instanceof
    void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient patient = (Patient) obj;
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patient.patientID);
            System.out.println("Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Ailment: " + patient.ailment);
            System.out.println();
        }
    }
}

public class HospitalApp {
    public static void main(String[] args) {

        Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");

        Patient.getTotalPatients();

        patient1.displayDetails(patient1);
        patient2.displayDetails(patient2);
    }
}
