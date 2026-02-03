import java.util.Arrays;
import java.util.List;

public class HospitalPatientPrintingApp {

    public static void main(String[] args) {

        List<String> patientIds = Arrays.asList(
                "P101", "P102", "P103", "P104"
        );

        // Lambda version
        // patientIds.forEach(id -> System.out.println(id));

        // Method Reference version
        patientIds.forEach(System.out::println);
    }
}
