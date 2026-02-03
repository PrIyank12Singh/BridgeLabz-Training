import java.io.Serializable; // IMPORTANT: import Serializable

public class BackupApp {

    public static void main(String[] args) {
        CustomerData customer = new CustomerData("Alice", 30);

        if (customer instanceof Serializable) {
            System.out.println(customer + " is marked as Serializable. Ready for backup!");
        } else {
            System.out.println(customer + " cannot be backed up.");
        }
    }
}
