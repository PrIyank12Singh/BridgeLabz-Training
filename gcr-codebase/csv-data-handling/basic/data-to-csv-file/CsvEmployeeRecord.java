public class CsvEmployeeRecord {

    private int id;
    private String name;
    private String department;
    private double salary;

    public CsvEmployeeRecord(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toCsvRow() {
        return id + "," + name + "," + department + "," + salary;
    }
}
