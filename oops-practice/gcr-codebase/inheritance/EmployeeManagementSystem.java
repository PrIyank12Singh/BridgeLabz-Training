abstract class Employee {

    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // common behavior
    protected void displayBasicDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    //implemented by subclass
    public abstract void displayDetails();
}

// manager is a Employee
class Manager extends Employee {

    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        displayBasicDetails();
        System.out.println("Team Size: " + teamSize);
        System.out.println("Role: Manager");
    }
}

// developer is a Employee
class Developer extends Employee {

    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        displayBasicDetails();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Role: Developer");
    }
}

// intern IS-A Employee
class Intern extends Employee {

    private int durationInMonths;

    public Intern(String name, int id, double salary, int durationInMonths) {
        super(name, id, salary);
        this.durationInMonths = durationInMonths;
    }

    @Override
    public void displayDetails() {
        displayBasicDetails();
        System.out.println("Internship Duration: " + durationInMonths + " months");
        System.out.println("Role: Intern");
    }
}

// main class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Employee manager = new Manager("Ansh", 101, 80000, 5);
        Employee developer = new Developer("Neha", 102, 60000, "Java");
        Employee intern = new Intern("Naman", 103, 15000, 6);

        manager.displayDetails();
        System.out.println();

        developer.displayDetails();
        System.out.println();

        intern.displayDetails();
    }
}
