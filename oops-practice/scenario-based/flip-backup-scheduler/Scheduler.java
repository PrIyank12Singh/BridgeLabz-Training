public class Scheduler {
    public static void main(String[] args) {
        BackupScheduler scheduler = new BackupScheduler();

        try {
            scheduler.addTask(new BackupTask("/collections-practice/scenario-based/flip-backup-scheduler", 3)); // medium priority
            scheduler.addTask(new BackupTask("/collections-practice/scenario-based/restaurant-table-reservation-system", 5));  // high priority
            scheduler.addTask(new BackupTask("/collections-practice/gcr-codebase/collections", 1));  // low priority
            scheduler.addTask(new BackupTask("/collections-practice/gcr-codebase/exceptions", 4)); // invalid path, should throw exception
        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scheduler.executeTasks();
    }
}
