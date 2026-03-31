import java.util.*;

abstract class Product {

    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    abstract void displayDetails();

    double totalValue() {
        return price * quantity;
    }
}

class ElectronicsProduct extends Product {

    int warranty;

    ElectronicsProduct(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    void displayDetails() {
        System.out.println(name + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Warranty: " + warranty + " months");
    }
}

class ClothingProduct extends Product {

    String size;

    ClothingProduct(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    void displayDetails() {
        System.out.println(name + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Size: " + size);
    }
}

public class SupermarketInventorySystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> inventory = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] p = line.split(",\\s*");

            String type = p[0];

            if (type.equals("Electronics")) {

                Product prod = new ElectronicsProduct(
                        p[1],
                        Double.parseDouble(p[2]),
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4])
                );

                inventory.add(prod);
                System.out.println("Product added to inventory: " + p[1]);
            }

            else if (type.equals("Clothing")) {

                Product prod = new ClothingProduct(
                        p[1],
                        Double.parseDouble(p[2]),
                        Integer.parseInt(p[3]),
                        p[4]
                );

                inventory.add(prod);
                System.out.println("Product added to inventory: " + p[1]);
            }
        }

        System.out.println("Inventory:");

        double total = 0;

        for (Product p : inventory) {
            p.displayDetails();
            total += p.totalValue();
        }

        System.out.printf("Total value of the inventory: %.2f", total);
    }
}