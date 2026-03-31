import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 4000);
        Policy p3 = new Policy("P103", "Alice", LocalDate.now().plusDays(20), "Home", 6000);
        Policy p4 = new Policy("P104", "Carol", LocalDate.now().minusDays(5), "Life", 7000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        System.out.println("Retrieve policy P101:");
        System.out.println(manager.getPolicy("P101"));

        System.out.println("\nPolicies expiring in next 30 days:");
        List<Policy> expiring = manager.policiesExpiringSoon();
        expiring.forEach(System.out::println);

        System.out.println("\nPolicies for Alice:");
        manager.policiesByHolder("Alice").forEach(System.out::println);

        System.out.println("\nRemove expired policies...");
        manager.removeExpired();

        System.out.println("\nAll policies in HashMap:");
        manager.displayAllHashMap();

        System.out.println("\nAll policies in LinkedHashMap:");
        manager.displayAllLinkedHashMap();

        System.out.println("\nAll policies sorted by expiry (TreeMap):");
        manager.displayAllTreeMap();
    }
}
