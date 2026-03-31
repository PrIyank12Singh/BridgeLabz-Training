public class PatientRecord implements SensitiveData {
    private String name;
    private String diagnosis;

    public PatientRecord(String name, String diagnosis) {
        this.name = name;
        this.diagnosis = diagnosis;
    }

    public String toString() {
        return "PatientRecord[name=" + name + ", diagnosis=" + diagnosis + "]";
    }
}
