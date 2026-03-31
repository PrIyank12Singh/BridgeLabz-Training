public class TaskRunnerV1 extends Thread {

    public TaskRunnerV1(String name) {
        super(name);
    }

    @Override
    public void run() {

        try {
            // TIMED_WAITING
            Thread.sleep(2000);

            // RUNNABLE (Computation)
            for (int i = 0; i < 5; i++) {
                double result = Math.sqrt(i * 100);
                System.out.println(getName() + " computing value: " + result);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
