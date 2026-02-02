public class EmployeeDbRecord {

    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public EmployeeDbRecord(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toCsvRow() {
        return employeeId + "," + name + "," + department + "," + salary;
    }

    public void printRecord() {
        System.out.println("Employee ID: " + employeeId +
                           ", Name: " + name +
                           ", Department: " + department +
                           ", Salary: " + salary);
    }
}
