public class Mains {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create accounts
        SavingsAccount savings = new SavingsAccount("SAV001", 1000, 5.0);
        CurrentAccount current = new CurrentAccount("CUR001", 500, 200);
        bank.createAccount(savings);
        bank.createAccount(current);

        // Simulate concurrent transfers using threads
        Thread t1 = new Thread(() -> {
            try {
                bank.transfer("SAV001", "CUR001", 200);
                System.out.println("Transfer 1 completed.");
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                bank.transfer("CUR001", "SAV001", 100);
                System.out.println("Transfer 2 completed.");
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check balances and history
        System.out.println("Savings Balance: " + bank.getBalance("SAV001"));
        System.out.println("Current Balance: " + bank.getBalance("CUR001"));
        System.out.println("Savings History: " + bank.getTransactionHistory("SAV001"));
        System.out.println("Current History: " + bank.getTransactionHistory("CUR001"));
    }
}