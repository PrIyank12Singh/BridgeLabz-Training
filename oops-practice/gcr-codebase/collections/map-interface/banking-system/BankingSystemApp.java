public class BankingSystemApp {

    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        // Add accounts
        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 3000);
        bank.addAccount("A103", 7000);

        // Display unsorted accounts
        System.out.println("----- All Accounts -----");
        bank.displayAllAccounts();

        // Queue withdrawal requests
        bank.requestWithdrawal("A101", 2000);
        bank.requestWithdrawal("A102", 4000); // insufficient
        bank.requestWithdrawal("A103", 1000);

        System.out.println("\n----- Processing Withdrawals -----");
        bank.processWithdrawals();

        System.out.println("\n----- Accounts After Withdrawals -----");
        bank.displayAllAccounts();

        System.out.println("\n----- Accounts Sorted by Balance -----");
        bank.displayAccountsSortedByBalance();
    }
}
