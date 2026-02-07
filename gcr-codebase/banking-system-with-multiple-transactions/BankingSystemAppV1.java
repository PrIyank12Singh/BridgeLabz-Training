public class BankingSystemAppV1 {

    public static void main(String[] args) {

        BankAccountV1 account = new BankAccountV1();

        Thread t1 = new Thread(new TransactionTaskV1(account, "Customer-1", 3000), "ATM-1");
        Thread t2 = new Thread(new TransactionTaskV1(account, "Customer-2", 4000), "ATM-2");
        Thread t3 = new Thread(new TransactionTaskV1(account, "Customer-3", 2000), "ATM-3");
        Thread t4 = new Thread(new TransactionTaskV1(account, "Customer-4", 5000), "ATM-4");
        Thread t5 = new Thread(new TransactionTaskV1(account, "Customer-5", 1500), "ATM-5");

        System.out.println("State before start:");
        System.out.println(t1.getName() + " -> " + t1.getState());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
