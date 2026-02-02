import java.lang.reflect.Method;

class Calculator {

    int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {

    public static void main(String[] args) {

        try {
            Calculator calc = new Calculator();

            // Get Class object
            Class<?> cls = calc.getClass();

            // Get private method multiply(int, int)
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            // Make private method accessible
            method.setAccessible(true);

            // Invoke method
            int result = (int) method.invoke(calc, 5, 4);

            System.out.println("Result of multiplication: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
