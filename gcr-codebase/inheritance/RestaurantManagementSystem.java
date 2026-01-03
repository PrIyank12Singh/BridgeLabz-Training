// interface defining worker 
interface Worker {
    void performDuties();
}

// superclass for all person
abstract class Person {

    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    protected void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// chef is a Person and  Worker
class Chef extends Person implements Worker {

    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        displayPersonInfo();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Cooking dishes, planning menus");
    }
}

// waiter is a Person and Worker
class Waiter extends Person implements Worker {

    private int experienceYears;

    public Waiter(String name, int id, int experienceYears) {
        super(name, id);
        this.experienceYears = experienceYears;
    }

    @Override
    public void performDuties() {
        displayPersonInfo();
        System.out.println("Role: Waiter");
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Duties: Serving food, attending customers");
    }
}

// main class
public class RestaurantManagementSystem {

    public static void main(String[] args) {

        Worker chef = new Chef("Devarshi", 01, "Italian Cuisine");
        Worker waiter = new Waiter("Anjali", 02, 5);

        Worker[] staff = {chef, waiter};

        for (Worker worker : staff) {
            worker.performDuties();
            System.out.println();
        }
    }
}
