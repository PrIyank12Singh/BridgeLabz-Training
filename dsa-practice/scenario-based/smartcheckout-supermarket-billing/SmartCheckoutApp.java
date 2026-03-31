import java.util.Arrays;

public class SmartCheckoutApp {

    public static void main(String[] args) {

        SmartCheckout checkout = new SmartCheckout();

        // Add items to store
        checkout.addItemToStore("Apple", 2.0, 10);
        checkout.addItemToStore("Banana", 1.0, 5);
        checkout.addItemToStore("Milk", 3.5, 2);
        checkout.addItemToStore("Bread", 2.5, 3);

        checkout.displayStoreItems();
        System.out.println();

        // Add customers
        checkout.addCustomer(new Customer("Alice", Arrays.asList("Apple", "Banana", "Milk")));
        checkout.addCustomer(new Customer("Bob", Arrays.asList("Bread", "Milk", "Milk")));
        checkout.addCustomer(new Customer("Carol", Arrays.asList("Apple", "Bread", "Banana")));

        System.out.println("----- Processing Checkout Queue -----");
        checkout.processCheckout();

        System.out.println("----- Store Items After Checkout -----");
        checkout.displayStoreItems();
    }
}
