public class BackupTask implements Comparable<BackupTask> {
    private String folderPath;
    private int priority; // higher number = higher priority

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Backup path cannot be empty!");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        // Higher priority comes first
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "BackupTask{" +
                "folderPath='" + folderPath + '\'' +
                ", priority=" + priority +
                '}';
    }
}
