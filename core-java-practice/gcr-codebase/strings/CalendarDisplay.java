import java.util.Scanner;

public class CalendarDisplay {

    static String[] months = {"January","February","March","April","May","June",
                              "July","August","September","October","November","December"};
    static int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

    // Leap year check
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Number of days in a month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return daysInMonth[month - 1];
    }

    // Day of the week using Zeller's Congruence
    public static int getFirstDay(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month)/12) - 2;
        return (1 + x + (31*m)/12) % 7; // 0=Sunday, 6=Saturday
    }

    // Display calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("     " + months[month - 1] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int firstDay = getFirstDay(month, year);
        int numDays = getDaysInMonth(month, year);

        // Print leading spaces
        for (int i = 0; i < firstDay; i++) System.out.print("   ");

        // Print days
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%2d ", day);
            if ((day + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter month (1-12):");
        int month = input.nextInt();
        System.out.println("Enter year:");
        int year = input.nextInt();

        displayCalendar(month, year);
        input.close();
    }
}
