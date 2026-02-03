public class BackgroundJobExecution {

    public static void main(String[] args) {

        // Runnable task using lambda
        Runnable task = () -> {
            System.out.println("Background job started...");
            try {
                Thread.sleep(2000); // Simulate task taking time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background job finished!");
        };

        // Run task in a new thread
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Main thread continues...");
    }
}
