public abstract class JobRole {

    private String roleName;

    protected JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract String requiredSkills();
}
