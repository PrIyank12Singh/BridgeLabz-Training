public class EncryptedEmployeeRecord {

    private int employeeId;
    private String name;
    private String department;
    private String salary; // encrypted as string
    private String email;  // encrypted as string

    public EncryptedEmployeeRecord(int employeeId, String name, String department, String salary, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getSalary() { return salary; }
    public String getEmail() { return email; }

    public String toCsvRow() {
        return employeeId + "," + name + "," + department + "," + salary + "," + email;
    }
}
