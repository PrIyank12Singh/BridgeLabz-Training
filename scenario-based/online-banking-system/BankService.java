import java.util.List;

public interface BankService {
    void createAccount(Account account);
    double getBalance(String accountId);
    void transfer(String fromAccountId, String toAccountId, double amount) throws InsufficientBalanceException;
    List<Transaction> getTransactionHistory(String accountId);
}