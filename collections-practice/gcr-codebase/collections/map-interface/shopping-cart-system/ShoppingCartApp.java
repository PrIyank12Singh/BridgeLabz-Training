public class ShoppingCartApp {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Add products
        cart.addProduct("Apple", 50.0);
        cart.addProduct("Banana", 20.0);
        cart.addProduct("Mango", 80.0);
        cart.addProduct("Orange", 30.0);

        System.out.println("----- Shopping Cart -----");
        cart.displayAllProducts();
        cart.displayInsertionOrder();
        cart.displaySortedByName();
        cart.displaySortedByPrice();
    }
}
