abstract class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    //role describe itself 
    public abstract void displayRole();
}

// teacher is a  Person
class Teacher extends Person {

    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// student is a Person
class Student extends Person {

    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// staff is a Person
class Staff extends Person {

    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// main class
public class SchoolSystem {

    public static void main(String[] args) {

        Person[] people = new Person[3];

        people[0] = new Teacher("Mr.Sanjay", 40, "English");
        people[1] = new Student("Anita", 16, "10th Grade");
        people[2] = new Staff("Ramesh", 35, "Administration");

        for (Person person : people) {
            person.displayRole();
            System.out.println();
        }
    }
}
