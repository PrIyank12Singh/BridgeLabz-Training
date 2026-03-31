class Wallet {
    private User user;
    private double balance;

    private Transaction[] transactions = new Transaction[100];
    private int txCount = 0;

    public Wallet(User user) {
        this.user = user;
        this.balance = 0;
    }

    public void addMoney(double amount) {
        balance += amount;
        addTransaction(new Transaction("Added", amount));
        System.out.println("Money added successfully.");
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance!");
        }
        balance -= amount;
        addTransaction(new Transaction("Withdrawn", amount));
        System.out.println("Money withdrawn successfully.");
    }

    public void deduct(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance for transfer!");
        }
        balance -= amount;
    }

    public void recordTransfer(String type, double amount) {
        addTransaction(new Transaction(type, amount));
    }

    private void addTransaction(Transaction t) {
        if (txCount < transactions.length) {
            transactions[txCount++] = t;
        }
    }

    public void showTransactions() {
        if (txCount == 0) {
            System.out.println("No transactions yet.");
            return;
        }

        for (int i = 0; i < txCount; i++) {
            transactions[i].display();
        }
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }
}
