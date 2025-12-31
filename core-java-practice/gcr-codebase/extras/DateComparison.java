import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        LocalDate date1 = LocalDate.parse(scan.nextLine());

        
        LocalDate date2 = LocalDate.parse(scan.nextLine());

        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date");
        } 
        else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date");
        } 
        else {
            System.out.println("Both dates are SAME");
        }

        scan.close();
    }
}
