import java.util.Scanner;

public class ChocolatesDistribution {

    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        //finding distribution
        int eachChildGets = chocolates / children;
        int remaining = chocolates % children;
        return new int[]{eachChildGets, remaining};
    }

    public static void main(String[] args) {

        //taking input of chocolates and children
        Scanner scan = new Scanner(System.in);
        int chocolates = scan.nextInt();
        int children = scan.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);

        scan.close();
    }
}
