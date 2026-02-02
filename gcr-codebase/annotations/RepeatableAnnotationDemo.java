import java.lang.annotation.*;
import java.lang.reflect.*;

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// TaskService class with repeatable annotations
class TaskService {

    @BugReport(description = "Null pointer exception on start")
    @BugReport(description = "Incorrect calculation in processTask")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

// Main class
public class RepeatableAnnotationDemo {

    public static void main(String[] args) {

        try {
            Class<TaskService> cls = TaskService.class;

            Method method = cls.getMethod("processTask");

            // Retrieve all BugReport annotations
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

            System.out.println("Bug Reports for processTask():");

            for (BugReport bug : bugReports) {
                System.out.println("- " + bug.description());
            }

            // Call the method
            TaskService ts = new TaskService();
            method.invoke(ts);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
