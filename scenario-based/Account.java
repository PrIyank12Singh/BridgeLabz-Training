import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String accountId;
    protected double balance;
    protected List<Transaction> transactionHistory;

    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", -amount));
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    // Polymorphic method for interest calculation
    public abstract double calculateInterest();
}