import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class CacheResultDemo {

    public static void main(String[] args) throws Exception {
        MathService service = new MathService();

        // Cache storage: method name + input -> result
        Map<String, Map<Object, Object>> cache = new HashMap<>();

        Method method = MathService.class.getMethod("factorial", int.class);

        int[] inputs = {5, 6, 5}; // 5 repeated to test cache

        for (int n : inputs) {
            Object result;

            if (method.isAnnotationPresent(CacheResult.class)) {

                // Initialize method cache if not present
                cache.putIfAbsent(method.getName(), new HashMap<>());
                Map<Object, Object> methodCache = cache.get(method.getName());

                if (methodCache.containsKey(n)) {
                    System.out.println("Returning cached result for input " + n);
                    result = methodCache.get(n);
                } else {
                    result = method.invoke(service, n);
                    methodCache.put(n, result);
                }
            } else {
                result = method.invoke(service, n);
            }

            System.out.println("factorial(" + n + ") = " + result);
        }
    }
}
