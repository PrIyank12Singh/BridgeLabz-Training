import java.util.*;

class DeliveryService {

    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agentList = new ArrayList<>();
    private Map<Order, Agent> activeDeliveries = new HashMap<>();

    // Add Agent
    public void addAgent(Agent agent) {
        agentList.add(agent);
    }

    // Place Order
    public void placeOrder(Order order) {
        orderQueue.offer(order);
    }

    // Assign Order FIFO to nearest available agent
    public void assignOrder() throws NoAgentAvailableException {

        if (orderQueue.isEmpty()) {
            System.out.println("No orders to assign.");
            return;
        }

        Order order = orderQueue.peek();

        Agent nearestAgent = null;

        for (Agent agent : agentList) {
            if (agent.isAvailable() && agent.getLocation().equals(order.getLocation())) {
                nearestAgent = agent;
                break;
            }
        }

        if (nearestAgent == null) {
            throw new NoAgentAvailableException("No available agent for location: "
                    + order.getLocation());
        }

        orderQueue.poll(); // remove from queue
        nearestAgent.assignOrder();
        activeDeliveries.put(order, nearestAgent);

        System.out.println("Order assigned successfully.");
    }

    // Cancel Order
    public void cancelOrder(int orderId) {
        orderQueue.removeIf(order -> order.getOrderId() == orderId);
        System.out.println("Order cancelled if present in queue.");
    }

    // View Active Deliveries
    public void viewActiveDeliveries() {
        if (activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries.");
            return;
        }

        for (Map.Entry<Order, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println(entry.getKey() + " -> Delivered by -> " + entry.getValue());
        }
    }
}
