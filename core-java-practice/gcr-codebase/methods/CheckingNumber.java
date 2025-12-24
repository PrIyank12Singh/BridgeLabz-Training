import java.util.Scanner;

public class CheckingNumber {

  //checking number
    public static int checkNumber(int num) {
        if (num > 0)
            return 1;
        else if (num < 0)
            return -1;
        else
            return 0;
    }

    //taking input and printing

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        int result = checkNumber(num);
        System.out.println(result);

        scan.close();
    }
}
