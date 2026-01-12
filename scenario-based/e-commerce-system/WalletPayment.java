class Order {
    int orderId;
    private Product product;
    Customer customer;
    private boolean cancelled;

    public Order(int orderId, Product product, Customer customer) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.cancelled = false;
    }

    public void placeOrder(Payment payment) {
        try {
            payment.pay(product.getPrice());
            System.out.println("Order placed for " + product.getName());
        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    public void cancelOrder() {
        cancelled = true;
        System.out.println("Order cancelled");
    }

    public void trackOrder() {
        if (cancelled) {
            System.out.println("Order status: Cancelled");
        } else {
            System.out.println("Order status: In delivery");
        }
    }
}
