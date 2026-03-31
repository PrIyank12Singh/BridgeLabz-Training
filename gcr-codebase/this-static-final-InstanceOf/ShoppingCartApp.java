class Product {

    // static variable shared by all products
    static double discount = 0.0;

    // instance variables
    String productName;
    double price;
    int quantity;

    // final variable
    final String productID;

    // constructor using this
    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // static method to update discount
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // method to display product details
    void displayDetails(Object obj) {

        // instanceof check
        if (obj instanceof Product) {
            Product product = (Product) obj;

            double discountedPrice = product.price - (product.price * discount / 100);

            System.out.println("Product ID: " + product.productID);
            System.out.println("Product Name: " + product.productName);
            System.out.println("Price: $" + product.price);
            System.out.println("Quantity: " + product.quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + discountedPrice);
            System.out.println();
        }
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {

        // update discount for all products
        Product.updateDiscount(10.0);

        // create Product objects
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);

        // display product details
        product1.displayDetails(product1);
        product2.displayDetails(product2);
    }
}
