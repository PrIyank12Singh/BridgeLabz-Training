import java.util.*;

public class ShoppingCart {

    // Product -> Price
    private Map<String, Double> productsHashMap = new HashMap<>();
    private Map<String, Double> productsLinkedHashMap = new LinkedHashMap<>();

    // Add product to cart
    public void addProduct(String product, double price) {
        productsHashMap.put(product, price);
        productsLinkedHashMap.put(product, price);
    }

    // Display items in insertion order
    public void displayInsertionOrder() {
        System.out.println("Cart (Insertion Order): " + productsLinkedHashMap);
    }

    // Display items sorted by product name
    public void displaySortedByName() {
        TreeMap<String, Double> sortedByName = new TreeMap<>(productsHashMap);
        System.out.println("Cart (Sorted by Product Name): " + sortedByName);
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        // TreeMap cannot sort by value directly; use a list of entries
        List<Map.Entry<String, Double>> list = new ArrayList<>(productsHashMap.entrySet());
        list.sort(Map.Entry.comparingByValue());

        System.out.println("Cart (Sorted by Price): ");
        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // Display all items (HashMap, unsorted)
    public void displayAllProducts() {
        System.out.println("Cart (HashMap, Unsorted): " + productsHashMap);
    }
}
