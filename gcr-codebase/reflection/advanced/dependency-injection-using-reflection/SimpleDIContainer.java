import java.lang.reflect.Field;

public class SimpleDIContainer {

    public static <T> T createObject(Class<T> clazz) {

        try {
            // Create main object
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Scan fields
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {

                // Check @Inject annotation
                if (field.isAnnotationPresent(Inject.class)) {

                    // Create dependency object
                    Class<?> fieldType = field.getType();
                    Object dependency = fieldType
                            .getDeclaredConstructor()
                            .newInstance();

                    // Inject dependency
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("DI failed", e);
        }
    }
}
