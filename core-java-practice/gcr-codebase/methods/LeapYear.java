import java.util.Scanner;

public class LeapYear {

    public static boolean isLeapYear(int year) {
      //checking conditions for a leap year
      if (year < 1582)
            return false;

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //taking year as a input
        int year = scan.nextInt();

        if (isLeapYear(year))
            System.out.println("Leap Year");
        else
            System.out.println("Not a Leap Year");

        scan.close();
    }
}
