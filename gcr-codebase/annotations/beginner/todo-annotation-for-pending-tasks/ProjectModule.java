class ProjectModule {

    @Todo(task = "Implement login feature", assignedTo = "Priyank", priority = "HIGH")
    public void login() {
        System.out.println("Login module in progress...");
    }

    @Todo(task = "Add reporting feature", assignedTo = "Ankit")
    public void report() {
        System.out.println("Reporting module in progress...");
    }

    public void dashboard() {
        System.out.println("Dashboard completed");
    }
}
