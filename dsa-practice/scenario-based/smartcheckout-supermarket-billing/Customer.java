import java.util.List;

public class Customer {
    String name;
    List<String> shoppingList;

    public Customer(String name, List<String> shoppingList) {
        this.name = name;
        this.shoppingList = shoppingList;
    }

    @Override
    public String toString() {
        return name + " -> " + shoppingList;
    }
}
