class BankTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {

        double fee = 10;
        double total = amount + fee;

        from.deduct(total);
        to.addMoney(amount);

        from.recordTransfer("Bank Transfer Sent (Fee ₹10)", total);
        to.recordTransfer("Bank Transfer Received", amount);

        System.out.println("Bank transfer successful with ₹10 fee.");
    }
}
