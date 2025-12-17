import java.util.*;

class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int base = sc.nextInt();
        int exponent = sc.nextInt();

        System.out.println((int)Math.pow(base,exponent));

        
        sc.close();
    }
}
