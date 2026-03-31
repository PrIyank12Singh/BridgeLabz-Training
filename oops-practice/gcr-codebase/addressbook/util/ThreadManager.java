package util;

public class ThreadManager {

    // Run any Runnable in a separate thread
    public static void run(Runnable task) {
        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join(); // Wait until thread finishes (optional, can remove if you want non-blocking)
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
