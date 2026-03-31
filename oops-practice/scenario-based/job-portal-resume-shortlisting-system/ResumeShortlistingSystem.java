import java.util.*;

public class ResumeShortlistingSystem {

    private List<Resume> resumes = new ArrayList<>();

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public List<Resume> shortlistResumes(Set<String> requiredSkills) {
        List<Resume> ranked = new ArrayList<>(resumes);

        // Sort resumes based on number of matching skills
        ranked.sort(new Comparator<Resume>() {
            @Override
            public int compare(Resume r1, Resume r2) {
                long match1 = r1.getSkills().stream().filter(requiredSkills::contains).count();
                long match2 = r2.getSkills().stream().filter(requiredSkills::contains).count();
                return Long.compare(match2, match1); // descending order
            }
        });

        return ranked;
    }

    public static void main(String[] args) {
        try {
            Resume r1 = new Resume("Alice", Set.of("Java", "Spring", "SQL"));
            Resume r2 = new Resume("Bob", Set.of("Python", "Django", "SQL"));
            Resume r3 = new Resume("Charlie", Set.of("Java", "React", "AWS"));

            ResumeShortlistingSystem system = new ResumeShortlistingSystem();
            system.addResume(r1);
            system.addResume(r2);
            system.addResume(r3);

            Set<String> jobSkills = Set.of("Java", "SQL");

            List<Resume> shortlisted = system.shortlistResumes(jobSkills);
            System.out.println("Shortlisted Resumes:");
            shortlisted.forEach(System.out::println);

        } catch (InvalidResumeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
