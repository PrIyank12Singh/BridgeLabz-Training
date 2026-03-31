import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements BankService {
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public void createAccount(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    @Override
    public double getBalance(String accountId) {
        Account account = accounts.get(accountId);
        return account != null ? account.getBalance() : 0;
    }

    @Override
    public synchronized void transfer(String fromAccountId, String toAccountId, double amount) throws InsufficientBalanceException {
        Account fromAccount = accounts.get(fromAccountId);
        Account toAccount = accounts.get(toAccountId);

        if (fromAccount == null || toAccount == null) {
            throw new InsufficientBalanceException("Invalid account ID.");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        // Add to history
        fromAccount.getTransactionHistory().add(new Transaction("Transfer Out to " + toAccountId, -amount));
        toAccount.getTransactionHistory().add(new Transaction("Transfer In from " + fromAccountId, amount));
    }

    @Override
    public List<Transaction> getTransactionHistory(String accountId) {
        Account account = accounts.get(accountId);
        return account != null ? account.getTransactionHistory() : null;
    }
}