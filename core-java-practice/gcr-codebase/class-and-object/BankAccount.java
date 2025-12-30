class BankAccount {

    // attributes
    String accountHolder;
    String accountNumber;
    double balance;

    // method to deposit money
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    // method to withdraw money
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // method to display balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // main method
    public static void main(String[] args) {

        BankAccount acc = new BankAccount();
        acc.accountHolder = "State of Chennai";
        acc.balance = 700;

        System.out.println("State of Chennai\n");
        acc.displayBalance();
        acc.deposit(200);
        acc.withdraw(100);
        acc.withdraw(1000);
    }
}
