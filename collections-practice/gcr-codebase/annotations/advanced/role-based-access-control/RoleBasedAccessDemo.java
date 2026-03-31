import java.lang.reflect.Method;

public class RoleBasedAccessDemo {

    public static void main(String[] args) {

        AdminService service = new AdminService();

        String currentUserRole = "USER"; // Change to "ADMIN" to Allow access

        Method[] methods = AdminService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);

                if (role.value().equals(currentUserRole)) {
                    try {
                        method.invoke(service);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Access Denied! You need role: " + role.value());
                }

            } else {
                // Methods without @RoleAllowed are accessible by anyone
                try {
                    method.invoke(service);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
