import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User 1 name: ");
        User u1 = new User(1, sc.nextLine());
        Wallet w1 = new Wallet(u1);

        System.out.print("Enter User 2 name: ");
        User u2 = new User(2, sc.nextLine());
        Wallet w2 = new Wallet(u2);

        while (true) {
            System.out.println("\n--- Digital Wallet Menu ---");
            System.out.println("1. Add Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. View Transactions");
            System.out.println("5. View Balance");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter amount: ");
                        w1.addMoney(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        w1.withdrawMoney(sc.nextDouble());
                        break;

                    case 3:
                        System.out.println("1. Wallet Transfer");
                        System.out.println("2. Bank Transfer");
                        int t = sc.nextInt();

                        TransferService service =
                                (t == 1) ? new WalletTransfer() : new BankTransfer();

                        System.out.print("Enter amount: ");
                        double amt = sc.nextDouble();

                        service.transfer(w1, w2, amt);
                        break;

                    case 4:
                        w1.showTransactions();
                        break;

                    case 5:
                        System.out.println("Current Balance: INR" + w1.getBalance());
                        break;

                    case 6:
                        System.out.println("Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
