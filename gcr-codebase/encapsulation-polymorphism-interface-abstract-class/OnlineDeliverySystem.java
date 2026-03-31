import java.util.*;

// Interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation (Getters only)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Base Price: " + price);
    }
}

// Veg Item
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount on Veg items";
    }
}

// Non-Veg Item
class NonVegItem extends FoodItem {

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double extraCharge = 50; // non-veg charge
        return (getPrice() * getQuantity()) + extraCharge;
    }
}

// main class
public class OnlineDeliverySystem {

    // Polymorphic
    public static void processOrder(List<FoodItem> order) {

        double grandTotal = 0;

        for (FoodItem item : order) {
            item.getItemDetails();

            double total = item.calculateTotalPrice();

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
                total -= d.applyDiscount();
            }

            System.out.println("Final Price: " + total);
            grandTotal += total;
            System.out.println();
        }

        System.out.println("Grand Total: " + grandTotal);
    }

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 400, 2));
        order.add(new NonVegItem("Chicken Biryani", 500, 1));

        processOrder(order);
    }
}
