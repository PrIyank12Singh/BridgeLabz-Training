import java.util.Scanner;

public class CollinearPoints {

    // Method to check collinearity using slope formula
    public static boolean isCollinearUsingSlope(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        // To avoid division, use cross multiplication
        return (y2 - y1) * (x3 - x2) ==
               (y3 - y2) * (x2 - x1);
    }

    // Method to check collinearity using area of triangle
    public static boolean isCollinearUsingArea(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        double area = 0.5 * (x1 * (y2 - y3)
                           + x2 * (y3 - y1)
                           + x3 * (y1 - y2));

        return area == 0;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();

        if (isCollinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are Collinear (Slope Method)");
        } else {
            System.out.println("Points are NOT Collinear (Slope Method)");
        }

        if (isCollinearUsingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are Collinear (Area Method)");
        } else {
            System.out.println("Points are NOT Collinear (Area Method)");
        }

        scanner.close();
    }
}
