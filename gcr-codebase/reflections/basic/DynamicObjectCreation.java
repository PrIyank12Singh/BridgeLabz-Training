import java.lang.reflect.Constructor;

class Student {
    int id;
    String name;

    public Student() {
        id = 1;
        name = "Priyank";
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }
}

public class DynamicObjectCreation {

    public static void main(String[] args) {

        try {
            // Load Student class
            Class<?> cls = Class.forName("Student");

            // Get no-arg constructor
            Constructor<?> constructor = cls.getDeclaredConstructor();

            // Create object dynamically
            Object obj = constructor.newInstance();

            // Type casting
            Student student = (Student) obj;

            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
