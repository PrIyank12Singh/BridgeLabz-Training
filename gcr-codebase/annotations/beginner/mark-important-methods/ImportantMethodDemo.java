import java.lang.reflect.Method;

public class ImportantMethodDemo {

    public static void main(String[] args) {

        try {
            Class<Project> cls = Project.class;

            Method[] methods = cls.getDeclaredMethods();

            System.out.println("Annotated Methods:");

            for (Method method : methods) {

                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println(
                        "- " + method.getName() + " (Level: " + annotation.level() + ")"
                    );
                }
            }

            // Optional: Call methods
            Project p = new Project();
            p.deploy();
            p.test();
            p.documentation();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
