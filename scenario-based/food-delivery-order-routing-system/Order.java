class Order {
    private int orderId;
    private String customerName;
    private String location;

    public Order(int orderId, String customerName, String location) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.location = location;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Customer: " + customerName +
                ", Location: " + location;
    }
}
