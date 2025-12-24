import java.util.Scanner;

public class Trigonometry {

    public static double[] calculateTrigonometricFunctions(double angle) {
        //calculating sin, cos, tan
        double radians = Math.toRadians(angle);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);

        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        //taking input
        Scanner scan = new Scanner(System.in);
        double angle = scan.nextDouble();

        double[] result = calculateTrigonometricFunctions(angle);
        System.out.println("Sin: " + result[0]);
        System.out.println("Cos: " + result[1]);
        System.out.println("Tan: " + result[2]);

        scan.close();
    }
}
