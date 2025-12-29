import java.util.Scanner;

public class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int book = 1; book <= 5; book++) {
            System.out.println("\nBook " + book);

            //Enter due date
            int dueDate = scan.nextInt();

            //Enter return date
            int returnDate = scan.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;
                System.out.println("Late by " + lateDays + " days");
                System.out.println("Fine is INR" + fine);
            } else {
                System.out.println("No fine.");
            }
        }

        scan.close();
    }
}
