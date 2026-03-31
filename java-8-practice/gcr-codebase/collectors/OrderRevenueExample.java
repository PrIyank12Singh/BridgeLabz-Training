import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double total;

    Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }

    public String getCustomer() { return customer; }
    public double getTotal() { return total; }
}

public class OrderRevenueExample {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", 250.0),
            new Order("Bob", 150.5),
            new Order("Alice", 100.0),
            new Order("Charlie", 300.0),
            new Order("Bob", 200.0)
        );

        Map<String, Double> revenuePerCustomer = orders.stream()
            .collect(Collectors.groupingBy(
                Order::getCustomer,
                Collectors.summingDouble(Order::getTotal)
            ));

        System.out.println(revenuePerCustomer);
    }
}
