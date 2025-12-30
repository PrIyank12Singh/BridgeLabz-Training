//Employee class definition
class Employee {

  //Instance variables(attributes)
    String name;
    int id;
    double salary;

    //Method to display employee details

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }


    
    public static void main(String[] args) {
        //Employee object
        Employee employee = new Employee();

        employee.name = "Rohan";
        employee.id = 1;
        employee.salary = 500000;

        employee.displayDetails();
    }
}
