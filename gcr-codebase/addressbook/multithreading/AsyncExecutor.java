import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void runAsync(Runnable task) {
        executor.submit(task);
    }
}
