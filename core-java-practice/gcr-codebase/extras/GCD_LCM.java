import java.util.Scanner;

public class GCD_LCM {

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println("GCD: " + gcd(a, b));
        System.out.println("LCM: " + lcm(a, b));

        input.close();
    }
}
