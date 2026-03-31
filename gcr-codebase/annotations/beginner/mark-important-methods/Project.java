class Project {

    @ImportantMethod
    public void deploy() {
        System.out.println("Deploying project...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void test() {
        System.out.println("Running tests...");
    }

    public void documentation() {
        System.out.println("Writing documentation... ");
    }
}
