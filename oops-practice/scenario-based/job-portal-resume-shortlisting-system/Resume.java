

import java.util.Set;

public class Resume {
    private String name;
    private Set<String> skills;

    public Resume(String name, Set<String> skills) throws InvalidResumeException {
        if (name == null || name.isEmpty() || skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Resume must have name and at least one skill.");
        }
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public Set<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Resume{" + "name='" + name + '\'' + ", skills=" + skills + '}';
    }
}
