import java.util.*;

// Custom Exception
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {

    // Parse invoice
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-")) {
            throw new InvalidInvoiceFormatException("Invalid format: Missing '-'");
        }
        return input.split(",");
    }

    // Calculate total amount
    public static int getTotalAmount(String[] tasks)
            throws InvalidInvoiceFormatException {

        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");

            if (parts.length < 2) {
                throw new InvalidInvoiceFormatException("Invalid task format: " + task);
            }

            String amountPart = parts[1].trim();

            try {
                int amount = Integer.parseInt(amountPart.split(" ")[0]);
                total += amount;
            } catch (Exception e) {
                throw new InvalidInvoiceFormatException("Invalid amount in task: " + task);
            }
        }
        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try {
            String[] tasks = parseInvoice(input);
            int total = getTotalAmount(tasks);
            System.out.println("Total Invoice Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println(e.getMessage());

        }

        sc.close();
    }
}
