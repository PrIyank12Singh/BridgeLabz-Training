import java.util.Scanner;

public class LineAndDistance {

    // Method to calculate Euclidean distance
    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to calculate slope and y-intercept of the line
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1); // slope
        double b = y1 - m * x1;           // y-intercept
        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two points
      
        double x1 = scanner.nextDouble();
      
        double y1 = scanner.nextDouble();
        
        double x2 = scanner.nextDouble();
        
        double y2 = scanner.nextDouble();

        // Calculate distance
        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance = " + distance);

        // Calculate line equation
        double[] equation = lineEquation(x1, y1, x2, y2);
        System.out.printf("Equation of line: y = %.2fx + %.2f\n", equation[0], equation[1]);

        scanner.close();
    }
}
