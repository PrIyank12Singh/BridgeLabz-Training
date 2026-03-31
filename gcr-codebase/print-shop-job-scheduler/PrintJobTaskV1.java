public class PrintJobTaskV1 implements Runnable {

    private String jobName;
    private int pages;

    public PrintJobTaskV1(String jobName, int pages) {
        this.jobName = jobName;
        this.pages = pages;
    }

    @Override
    public void run() {

        for (int i = 1; i <= pages; i++) {

            System.out.println("[" + Thread.currentThread().getName() +
                    "] Printing " + jobName +
                    " - Page " + i + " of " + pages);

            try {
                Thread.sleep(100); // 100ms per page
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
