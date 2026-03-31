import java.util.Scanner;

class BankAccount {
    String accountNumber;
    double balance;

    // constructor
    BankAccount(String accNo, double bal) {
        accountNumber = accNo;
        balance = bal;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else if (amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.nextLine();

        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, balance);

        account.deposit(500);
        account.withdraw(200);
        account.withdraw(1000); // overdraft check
        account.checkBalance();

        sc.close();
    }
}
