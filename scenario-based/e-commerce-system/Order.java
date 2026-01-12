public class Order {
    int orderId;
    private Product product;
    Customer customer;
    private boolean isCancelled;

    public Order(int orderId, Product product, Customer customer) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.isCancelled = false;
    }

    public void placeOrder(Payment payment) {
        try {
            payment.pay(product.getPrice());
            System.out.println("Order placed for " + product.getName());
        } catch (PaymentFailedException e) {
            System.out.println("Payment Failed: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        isCancelled = true;
        System.out.println("Order cancelled.");
    }

    public void trackOrder() {
        if (isCancelled)
            System.out.println("Order is cancelled.");
        else
            System.out.println("Order is out for delivery ");
    }
}
