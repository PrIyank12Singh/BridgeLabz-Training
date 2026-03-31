import java.io.Serializable;

/**
 * Represents a customer data object for backup.
 */
public class CustomerData implements Serializable {
    private String name;
    private int age;

    public CustomerData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Customer[name=" + name + ", age=" + age + "]";
    }
}
