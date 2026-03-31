import java.lang.reflect.Field;

class Person {
    int age = 20;
}

public class AccessPrivateField {

    public static void main(String[] args) {

        try {
            Person p = new Person();

            // Get Class object
            Class<?> cls = p.getClass();

            // Get private field 'age'
            Field field = cls.getDeclaredField("age");

            // Make private field accessible
            field.setAccessible(true);

            // Modify the value of age
            field.set(p, 25);

            // Retrieve the value of age
            int ageValue = (int) field.get(p);

            System.out.println("Modified age value: " + ageValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
