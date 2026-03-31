

public class PrintShopSchedulerAppV1 {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Thread job1 = new Thread(new PrintJobTaskV1("Job1", 10), "Priority-5");
        Thread job2 = new Thread(new PrintJobTaskV1("Job2", 5), "Priority-8");
        Thread job3 = new Thread(new PrintJobTaskV1("Job3", 15), "Priority-3");
        Thread job4 = new Thread(new PrintJobTaskV1("Job4", 8), "Priority-6");
        Thread job5 = new Thread(new PrintJobTaskV1("Job5", 12), "Priority-7");

        job1.setPriority(5);
        job2.setPriority(8);
        job3.setPriority(3);
        job4.setPriority(6);
        job5.setPriority(7);

        System.out.println("Starting print jobs...");

        job1.start();
        job2.start();
        job3.start();
        job4.start();
        job5.start();

        job1.join();
        job2.join();
        job3.join();
        job4.join();
        job5.join();

        long endTime = System.currentTimeMillis();

        System.out.println("All jobs completed in " +
                (endTime - startTime) + " ms");
    }
}
