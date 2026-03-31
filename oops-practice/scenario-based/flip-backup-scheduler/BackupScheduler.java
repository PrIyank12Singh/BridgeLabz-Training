import java.util.PriorityQueue;

public class BackupScheduler {
    private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

    // Add a backup task
    public void addTask(BackupTask task) {
        taskQueue.offer(task);
        System.out.println("Task added: " + task);
    }

    // Execute all tasks in priority order
    public void executeTasks() {
        System.out.println("\nExecuting backup tasks in priority order:");
        while (!taskQueue.isEmpty()) {
            BackupTask task = taskQueue.poll();
            System.out.println("Backing up folder: " + task.getFolderPath() + " (Priority: " + task.getPriority() + ")");
        }
    }
}
