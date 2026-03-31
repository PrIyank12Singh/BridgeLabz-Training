import java.util.ArrayList;
import java.util.List;

public class ResumeApp {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>("Amit", 3, new SoftwareEngineer());

        Resume<DataScientist> r2 =
                new Resume<>("Neha", 1, new DataScientist());

        Resume<ProductManager> r3 =
                new Resume<>("Rohit", 4, new ProductManager());

        process(r1);
        process(r2);
        process(r3);

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        ScreeningPipeline.runPipeline(roles);
    }

    private static <T extends JobRole> void process(Resume<T> resume) {
        ResumeProcessor.processResume(resume);

        if (ResumeProcessor.isEligible(resume)) {
            System.out.println("Status: Eligible\n");
        } else {
            System.out.println("Status: Not Eligible\n");
        }
    }
}
