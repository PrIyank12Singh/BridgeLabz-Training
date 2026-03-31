import java.util.*;

public class SmartCheckout {

    private Queue<Customer> checkoutQueue = new LinkedList<>();
    private Map<String, Item> storeItems = new HashMap<>();

    public void addItemToStore(String name, double price, int stock) {
        storeItems.put(name, new Item(name, price, stock));
    }

    public void addCustomer(Customer customer) {
        checkoutQueue.add(customer);
    }

    public void removeCustomer() {
        if (!checkoutQueue.isEmpty()) checkoutQueue.poll();
    }

    public void processCheckout() {
        while (!checkoutQueue.isEmpty()) {
            Customer customer = checkoutQueue.poll();
            System.out.println("Processing " + customer.name);
            double total = 0;

            for (String itemName : customer.shoppingList) {
                Item item = storeItems.get(itemName);
                if (item == null) {
                    System.out.println("Item not found: " + itemName);
                } else if (item.stock <= 0) {
                    System.out.println("Out of stock: " + itemName);
                } else {
                    total += item.price;
                    item.stock--;
                }
            }

            System.out.println("Total Bill for " + customer.name + ": INR " + total);
            System.out.println("-----------------------------");
        }
    }

    public void displayStoreItems() {
        System.out.println("Store Items:");
        for (Item item : storeItems.values()) {
            System.out.println(item.name + " - Price: INR " + item.price + ", Stock: " + item.stock);
        }
    }
}
