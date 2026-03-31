public class CsvEmployeeSearchRecord {

    private int id;
    private String name;
    private String department;
    private double salary;

    public CsvEmployeeSearchRecord(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void printDepartmentAndSalary() {
        System.out.println("Department : " + department);
        System.out.println("Salary     : " + salary);
    }
}
