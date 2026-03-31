class CartItem {

    // attributes
    String itemName;
    double price;
    int quantity;

    // method to add item
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // method to remove item
    void removeItem(int qty) {
        if (quantity >= qty) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        }
    }

    // method to display total cost
    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + total);
    }

    // main method
    public static void main(String[] args) {

        CartItem it = new CartItem();
        it.itemName = "Laptop";
        it.price = 999.99;
        it.quantity = 1;

        System.out.println("Item: Laptop, Price: $999.99, Quantity: 1");

        it.addItem(2);
        it.removeItem(1);
        it.displayTotalCost();
    }
}