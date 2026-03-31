import java.lang.reflect.Method ;

public class LogExecutionTimeDemo {

    public static void main(String[] args) {

        try {
            Class<PerformanceTest> cls = PerformanceTest.class;
            PerformanceTest obj = new PerformanceTest();

            Method[] methods = cls.getDeclaredMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(LogExecutionTime.class)) {

                    long start = System.nanoTime();
                    method.invoke(obj);
                    long end = System.nanoTime();

                    System.out.println(
                        "Execution time of " + method.getName() + ": " + (end - start) + " ns"
                    );
                }
            }

            // Call normalTask (not logged)
            obj.normalTask();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
