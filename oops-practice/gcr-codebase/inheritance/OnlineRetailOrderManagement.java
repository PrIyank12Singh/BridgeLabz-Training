abstract class Order {

    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    protected void displayBasicOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }

    // each level defines its own status
    public abstract String getOrderStatus();
}

// shippedOrder is a Order
class ShippedOrder extends Order {

    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    protected void displayShippingInfo() {
        displayBasicOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}

// deliveredOrder is a ShippedOrder
class DeliveredOrder extends ShippedOrder {

    private String deliveryDate;

    public DeliveredOrder(String orderId,
                          String orderDate,
                          String trackingNumber,
                          String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

// main class
public class OnlineRetailOrderManagement {

    public static void main(String[] args) {

        Order shippedOrder = new ShippedOrder(
                "ORD01",
                "2026-01-01",
                "TRK98765"
        );

        Order deliveredOrder = new DeliveredOrder(
                "ORD02",
                "2026-01-02",
                "TRK12345",
                "2026-01-04"
        );

        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}
