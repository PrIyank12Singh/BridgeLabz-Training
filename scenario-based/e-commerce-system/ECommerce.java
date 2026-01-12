public class ECommerce {
    public static void main(String[] args) {

        Product product = new Product(1, "Laptop", 4500);
        Customer customer = new Customer(101, "Priyank");

        Order order = new Order(5001, product, customer);

        Payment payment = new CardPayment();

        order.placeOrder(payment);
        order.trackOrder();

        order.cancelOrder();
        order.trackOrder();
    }
}