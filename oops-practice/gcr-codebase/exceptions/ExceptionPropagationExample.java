public class ExceptionPropagationExample {

    // Method that causes exception
    public static void method1() {
      int result = 10 / 0;   // ArithmeticException
    }

    // Method that calls method1
    public static void method2() {
        method1();            // exception propagates from here
    }

    public static void main(String[] args) {

        try {
            method2();        // exception propagates to main

        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
