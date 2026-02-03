public class EncryptionApp {

    public static void main(String[] args) {
        PatientRecord patient = new PatientRecord("John Doe", "Diabetes");

        if (patient instanceof SensitiveData) {
            System.out.println(patient + " is sensitive. Encrypting data...");
        } else {
            System.out.println(patient + " is not sensitive.");
        }
    }
}
