import java.util.Scanner;

public class QuotientRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        //finding quotient and remainder
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {

      //taking input number and divisor
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int divisor = scan.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);

        scan.close();
    }
}
