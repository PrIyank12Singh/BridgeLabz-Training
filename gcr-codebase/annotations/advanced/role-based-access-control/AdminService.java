class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }

    @RoleAllowed("ADMIN")
    public void accessSensitiveData() {
        System.out.println("Accessing sensitive data...");
    }

    public void viewProfile() {
        
        System.out.println("Profile viewed");
    }
}
