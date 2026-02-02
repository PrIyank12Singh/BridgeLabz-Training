public class CsvEmployeeSortRecord {

    private int id;
    private String name;
    private String department;
    private double salary;

    public CsvEmployeeSortRecord(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void printRecord() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("----------------------");
    }
}
