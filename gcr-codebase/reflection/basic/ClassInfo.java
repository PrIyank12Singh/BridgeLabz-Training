import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter class name (e.g. java.lang.String): ");
        String className = sc.nextLine();

        try {
            // Load class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }

            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println(f);
            }

            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }

        sc.close();
    }
}
