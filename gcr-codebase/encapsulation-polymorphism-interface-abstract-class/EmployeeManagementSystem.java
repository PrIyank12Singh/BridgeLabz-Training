import java.util.*;

// interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}
// abstract Class
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    protected double baseSalary;
    private String department;

    // constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // encapsulation's getters and setters 
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // interface methods
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }

    // abstract method
    public abstract double calculateSalary();

    // concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + calculateSalary());
        System.out.println( );
    }
}

// full-time employee
class FullTimeEmployee extends Employee {

    public FullTimeEmployee(int id, String name, double fixedSalary) {
        super(id, name, fixedSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary; // fixed monthly salary
    }
}

// part-time employee
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// main class
public class EmployeeManagementSystem {
    public static void main(String[] args) {

        // polymorphism using Employee reference
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new FullTimeEmployee(101, "Lakhan", 50000);
        e1.assignDepartment("IT");

        Employee e2 = new PartTimeEmployee(102, "Gagan", 40, 500);
        e2.assignDepartment("HR");

        employees.add(e1);
        employees.add(e2);

        // Processing list of employees using polymorphism
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
