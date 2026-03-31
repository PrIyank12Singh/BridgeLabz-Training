import java.lang.reflect.Method;

public class MethodTimingUtil {

    public static void executeWithTiming(
            Object target,
            String methodName,
            Class<?>[] paramTypes,
            Object[] args) {

        try {
            Class<?> cls = target.getClass();

            // Get method dynamically
            Method method = cls.getMethod(methodName, paramTypes);

            long startTime = System.nanoTime();

            // Invoke method
            method.invoke(target, args);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println(
                    "Method '" + methodName + "' executed in "
                    + duration + " ns");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
