import java.util.*;

// interface
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}

// abstract Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    // constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // encapsulation (Getters)
    public String getAccountNumber() {
        return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    // abstract method
    public abstract double calculateInterest();
}
//savings Account
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for ₹" + amount + " (Savings Account)");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}
//current Account
class CurrentAccount extends BankAccount {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02; // 2% interest
    }
}

//main Class
public class BankingSystem {

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SB123456", "Priyank", 50000);
        BankAccount acc2 = new CurrentAccount("CA987654", "Amit", 80000);

        accounts.add(acc1);
        accounts.add(acc2);

        //polymorphism in action
        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account No: " + acc.getAccountNumber());
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                System.out.println("Loan Eligibility: " +
                        ((Loanable) acc).calculateLoanEligibility());
            }

            System.out.println( );
        }
    }
}
