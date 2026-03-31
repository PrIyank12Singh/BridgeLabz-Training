class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    //parameterized constructor
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    void display() {
        System.out.println(employeeID + " " + department + " " + getSalary());
    }
}
