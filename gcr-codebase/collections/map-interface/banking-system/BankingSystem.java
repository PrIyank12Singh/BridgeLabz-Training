import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Amount: " + amount;
    }
}

public class BankingSystem {

    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add account
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    // Add withdrawal request
    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    // Process withdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            double balance = accounts.getOrDefault(req.accountNumber, 0.0);

            if (balance >= req.amount) {
                accounts.put(req.accountNumber, balance - req.amount);
                System.out.println("Processed: " + req);
            } else {
                System.out.println("Insufficient funds: " + req);
            }
        }
    }

    // Display all accounts (HashMap, unsorted)
    public void displayAllAccounts() {
        System.out.println("Accounts (HashMap, unsorted): " + accounts);
    }

    // Display accounts sorted by balance using TreeMap
    public void displayAccountsSortedByBalance() {
        // TreeMap cannot sort by value directly, so sort entries by value
        List<Map.Entry<String, Double>> list = new ArrayList<>(accounts.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<String, Double> entry : list) {
            System.out.println("Account: " + entry.getKey() + ", Balance: " + entry.getValue());
        }
    }
}
