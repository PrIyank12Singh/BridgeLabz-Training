import java.time.LocalDate;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P101", "Amit", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P102", "Ravi", LocalDate.now().plusDays(50), "Auto", 4000);
        Policy p3 = new Policy("P103", "Neha", LocalDate.now().plusDays(20), "Home", 6000);
        Policy p4 = new Policy("P101", "Amit", LocalDate.now().plusDays(10), "Health", 5000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4); // duplicate

        System.out.println("\nAll Unique Policies:");
        manager.displayAllPolicies();

        System.out.println("\nPolicies Expiring Soon:");
        manager.policiesExpiringSoon();

        System.out.println("\nHealth Policies:");
        manager.policiesByCoverage("Health");

        System.out.println("\nInsertion Order:");
        manager.displayInsertionOrder();

        System.out.println("\nSorted by Expiry:");
        manager.displaySortedByExpiry();

        System.out.println("\nDuplicate Detection:");
        manager.findDuplicates(Arrays.asList(p1, p2, p3, p4));

        System.out.println("\nPerformance Comparison:");
        manager.performanceTest(p1);
    }
}
