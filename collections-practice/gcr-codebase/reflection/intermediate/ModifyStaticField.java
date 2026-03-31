import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class ModifyStaticField {

    public static void main(String[] args) {

        try {
            // Get Class object
            Class<?> cls = Configuration.class;

            // Get private static field
            Field field = cls.getDeclaredField("API_KEY");

            // Make field accessible
            field.setAccessible(true);

            // Modify static field (object reference = null)
            field.set(null, "NEW_API_KEY_123");

            // Retrieve static field value
            String value = (String) field.get(null);

            System.out.println("Updated API_KEY: " + value);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
