public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountId, double initialBalance, double interestRate) {
        super(accountId, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate / 100;  // Polymorphism: Interest based on rate
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        transactionHistory.add(new Transaction("Interest Applied", interest));
    }
}