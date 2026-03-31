public class ResumeProcessor {

    public static <T extends JobRole> boolean isEligible(Resume<T> resume) {
        return resume.getExperienceYears() >= 2;
    }

    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println(
                "Processing " + resume.getCandidateName() +
                " for role: " + resume.getJobRole().getRoleName()
        );
    }
}
