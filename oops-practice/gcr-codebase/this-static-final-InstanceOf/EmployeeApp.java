class Employee {

    // static variables
    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;

    // instance variables
    String name;
    String designation;

    // final variable
    final int id;

    // constructor using this
    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // static method
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // method to display employee details
    void displayDetails(Object obj) {

        //instanceof check
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Designation: " + e.designation);
        }
    }
}

public class EmployeeApp {
    public static void main(String[] args) {

        // creating Employee objects
        Employee employee1 = new Employee(101, "Thamarai", "Software Engineer");
        Employee employee2 = new Employee(102, "Rohan", "Project Manager");

        // display total employees
        Employee.displayTotalEmployees();

        // display employee details
        employee1.displayDetails(employee1);
        employee2.displayDetails(employee2);
    }
}
