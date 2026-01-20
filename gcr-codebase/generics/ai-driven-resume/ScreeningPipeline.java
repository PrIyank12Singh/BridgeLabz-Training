import java.util.List;

public class ScreeningPipeline {

    public static void runPipeline(List<? extends JobRole> roles) {
        System.out.println("Screening for job roles:");

        for (JobRole role : roles) {
            System.out.println(
                    role.getRoleName() + " | Skills: " + role.requiredSkills()
            );
        }
    }
}
