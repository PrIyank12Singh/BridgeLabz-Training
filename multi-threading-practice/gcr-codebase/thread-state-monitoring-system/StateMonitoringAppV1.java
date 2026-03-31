public class StateMonitoringAppV1 {

    public static void main(String[] args) throws InterruptedException {

        TaskRunnerV1 task1 = new TaskRunnerV1("Task-1");
        TaskRunnerV1 task2 = new TaskRunnerV1("Task-2");

        ThreadStateMonitorV1 monitor =
                new ThreadStateMonitorV1(task1, task2);

        System.out.println("Initial State:");
        System.out.println(task1.getName() + " -> " + task1.getState());

        monitor.start();
        task1.start();
        task2.start();

        task1.join();
        task2.join();
        monitor.join();
    }
}
