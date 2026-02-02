import java.lang.reflect.Method;

public class TaskInfoDemo {

    public static void main(String[] args) {

        try {
            Class<TaskManager> cls = TaskManager.class;

            // Get method
            Method method = cls.getMethod("completeTask");

            // Check if annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Display annotation values
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

            // Execute the method
            TaskManager tm = new TaskManager();
            method.invoke(tm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
