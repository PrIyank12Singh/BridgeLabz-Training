abstract class BankAccount {

    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    protected void displayBasicDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    // account type for itself
    public abstract void displayAccountType();
}

// savingsAccount is a BankAccount
class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        displayBasicDetails();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// checkingaccount is a BankAccount
class CheckingAccount extends BankAccount {

    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        displayBasicDetails();
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// fixedDepositAccount is a BankAccount
class FixedDepositAccount extends BankAccount {

    private int maturityPeriod; // in months

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    @Override
    public void displayAccountType() {
        displayBasicDetails();
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

// main class
public class BankAccountTypes {

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new SavingsAccount("SB101", 50000, 4.5);
        accounts[1] = new CheckingAccount("CA202", 30000, 10000);
        accounts[2] = new FixedDepositAccount("FD303", 100000, 24);

        for (BankAccount account : accounts) {
            account.displayAccountType();
            System.out.println();
        }
    }
}
