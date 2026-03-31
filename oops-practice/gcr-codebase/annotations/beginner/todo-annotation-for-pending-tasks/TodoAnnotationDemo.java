import java.lang.reflect.Method;

public class TodoAnnotationDemo {

    public static void main(String[] args) {

        try {
            
            Class<ProjectModule> cls = ProjectModule.class;

            Method[] methods = cls.getDeclaredMethods();

            System.out.println("Pending Tasks:");

            for (Method method : methods) {
                if (method.isAnnotationPresent(Todo.class)) {
                    Todo todo = method.getAnnotation(Todo.class);
                    System.out.println(
                        "- Method: " + method.getName() +
                        ", Task: " + todo.task() +
                        ", Assigned To: " + todo.assignedTo() +
                        ", Priority: " + todo.priority()
                    );
                }
            }

            // Optional: Call methods
            ProjectModule pm = new ProjectModule();
            pm.login();
            pm.report();
            pm.dashboard();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
