

public class TransactionTaskV1 implements Runnable {

    private BankAccountV1 account;
    private String customerName;
    private int withdrawalAmount;

    public TransactionTaskV1(BankAccountV1 account, String customerName, int withdrawalAmount) {
        this.account = account;
        this.customerName = customerName;
        this.withdrawalAmount = withdrawalAmount;
    }

    @Override
    public void run() {
        account.withdraw(customerName, withdrawalAmount);
    }
}
