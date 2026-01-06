import java.util.*;

public class InvoiceGenerators {

    // Method to parse invoice string
    public static String[] parseInvoice(String input) {
        return input.split(",");
    }

    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");
            String amountPart = parts[1].trim(); // "3000 INR"
            int amount = Integer.parseInt(amountPart.split(" ")[0]);
            total += amount;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

  
        String input = sc.nextLine();

        String[] tasks = parseInvoice(input);

        System.out.println("\nInvoice Details:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }

        int totalAmount = getTotalAmount(tasks);
        System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");
        sc.close();
    }
}
