public class MethodTimingDemo {

    public static void main(String[] args) {

        TaskService service = new TaskService();

        MethodTimingUtil.executeWithTiming(
                service,
                "fastTask",
                new Class<?>[]{},
                new Object[]{}
        );

        MethodTimingUtil.executeWithTiming(
                service,
                "slowTask",
                new Class<?>[]{},
                new Object[]{}
        );
    }
}
