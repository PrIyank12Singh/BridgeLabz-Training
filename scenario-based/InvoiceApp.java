import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceApp {

    //Represents one invoice task
    static class InvoiceItem {
        private String taskName;
        private int amount;

        public InvoiceItem(String taskName, int amount) {
            this.taskName = taskName;
            this.amount = amount;
        }

        public String getTaskName() {
            return taskName;
        }

        public int getAmount() {
            return amount;
        }
    }

    // handles parsing logic
    static class InvoiceParser {

        public List<InvoiceItem> parseInvoice(String input) {
            List<InvoiceItem> items = new ArrayList<>();

            String[] tasks = input.split(",");

            for (String task : tasks) {
                String[] parts = task.trim().split("-");

                String taskName = parts[0].trim();
                String amountPart = parts[1].trim().split(" ")[0];

                int amount = Integer.parseInt(amountPart);

                items.add(new InvoiceItem(taskName, amount));
            }

            return items;
        }
    }

    // business logic class
    static class Invoice {
        private List<InvoiceItem> items;

        public Invoice(List<InvoiceItem> items) {
            this.items = items;
        }

        public int getTotalAmount() {
            int total = 0;
            for (InvoiceItem item : items) {
                total += item.getAmount();
            }
            return total;
        }

        public void displayInvoice() {
            System.out.println("\n--- Invoice Details ---");
            for (InvoiceItem item : items) {
                System.out.println(item.getTaskName() + " : " + item.getAmount() + " INR");
            }
            System.out.println("Total Amount: " + getTotalAmount() + " INR");
        }
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter invoice details:");
        System.out.println("Example: Logo Design - 3000 INR, Web Page - 4500 INR");

        String input = sc.nextLine();

        InvoiceParser parser = new InvoiceParser();
        List<InvoiceItem> items = parser.parseInvoice(input);

        Invoice invoice = new Invoice(items);
        invoice.displayInvoice();

        sc.close();
    }
}
