import java.util.Scanner;

// Custom Exception
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

// Class representing a single Task/Invoice Item
class Task {
    private String name;
    private int amount;

    public Task(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}

// Class representing the Invoice
class Invoice {
    private Task[] tasks;

    public Invoice(Task[] tasks) {
        this.tasks = tasks;
    }

    public int getTotalAmount() {
        int total = 0;
        for (Task t : tasks) {
            total += t.getAmount();
        }
        return total;
    }

    public void displayInvoice() {
        System.out.println("\n  Invoice Details  ");
        for (Task t : tasks) {
            System.out.println(t.getName() + " - " + t.getAmount() + " INR");
        }
        System.out.println("Total Amount: " + getTotalAmount() + " INR");
    }

    // Static method to parse input string into tasks
    public static Task[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        String[] taskStrings = input.split(",");
        Task[] tasks = new Task[taskStrings.length];

        for (int i = 0; i < taskStrings.length; i++) {
            String[] parts = taskStrings[i].trim().split(" - ");
            if (parts.length != 2) {
                throw new InvalidInvoiceFormatException("Invalid format for task: " + taskStrings[i]);
            }

            String name = parts[0].trim();
            int amount;
            try {
                amount = Integer.parseInt(parts[1].trim().replace("INR", "").trim());
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException("Invalid amount for task: " + taskStrings[i]);
            }

            tasks[i] = new Task(name, amount);
        }

        return tasks;
    }
}

// Main Application
public class InvoiceApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter invoice tasks (format: TaskName - Amount INR, ...):");
        String input = sc.nextLine();

        try {
            Task[] tasks = Invoice.parseInvoice(input);
            Invoice invoice = new Invoice(tasks);
            invoice.displayInvoice();
        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
