public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountId, double initialBalance, double overdraftLimit) {
        super(accountId, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance + overdraftLimit) {
            throw new InsufficientBalanceException("Overdraft limit exceeded.");
        }
        balance -= amount;
        transactionHistory.add(new Transaction("Withdrawal", -amount));
    }

    @Override
    public double calculateInterest() {
        return 0;  // Polymorphism: No interest for current accounts
    }
}