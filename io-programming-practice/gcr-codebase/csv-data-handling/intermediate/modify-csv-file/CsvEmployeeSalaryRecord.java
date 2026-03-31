public class CsvEmployeeSalaryRecord {

    private int id;
    private String name;
    private String department;
    private double salary;

    public CsvEmployeeSalaryRecord(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void increaseSalaryByPercent(double percent) {
        this.salary = this.salary + (this.salary * percent / 100);
    }

    public String toCsvRow() {
        return id + "," + name + "," + department + "," + salary;
    }
}
