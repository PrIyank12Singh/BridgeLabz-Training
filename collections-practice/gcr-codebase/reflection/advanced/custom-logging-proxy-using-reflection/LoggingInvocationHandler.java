import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class LoggingInvocationHandler implements InvocationHandler {

    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // Log before method execution
        System.out.println("Calling method: " + method.getName());

        // Invoke actual method
        return method.invoke(target, args);
    }
}
