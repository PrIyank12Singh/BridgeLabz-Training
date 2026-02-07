import java.time.LocalDateTime;

public class BankAccountV1 {

    private int balance = 10000;

    public void withdraw(String customerName, int amount) {

        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        if (balance >= amount) {

            try {
                Thread.sleep(300); // simulate processing delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance -= amount;

            System.out.println("Transaction successful: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalDateTime.now());

        } else {
            System.out.println("Transaction failed: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Insufficient Balance, Time: " + LocalDateTime.now());
        }
    }
}
