class WalletTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {

        from.deduct(amount);
        to.addMoney(amount);

        from.recordTransfer("Wallet Transfer Sent", amount);
        to.recordTransfer("Wallet Transfer Received", amount);

        System.out.println("Wallet to wallet transfer successful.");
    }
}
