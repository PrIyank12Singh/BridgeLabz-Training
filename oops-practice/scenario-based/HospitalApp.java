// interface
interface IPayable {
    double calculateBill();
}

// base class
class Patient {
    private int id;
    private String name;
    protected int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Patient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
// inheritance
class InPatient extends Patient implements IPayable {
    private int daysAdmitted;
    private double dailyCharge = 2000;

    public InPatient(int id, String name, int age, int daysAdmitted) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: InPatient");
        System.out.println("Total Bill: " + calculateBill());
    }
}

class OutPatient extends Patient implements IPayable {
    private double consultationFee = 500;

    public OutPatient(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: OutPatient");
        System.out.println("Total Bill: " + calculateBill());
    }
}
// main
public class HospitalApp {
    public static void main(String[] args) {
        Patient p1 = new InPatient(01, "Satpal", 30, 5);
        Patient p2 = new OutPatient(02, "Veerpal", 25);

        p1.displayInfo();
        System.out.println();
        p2.displayInfo();
    }
}
