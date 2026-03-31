import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Display all unique policies
    public void displayAllPolicies() {
        hashSet.forEach(System.out::println);
    }

    // Policies expiring in next 30 days
    public void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        hashSet.stream()
                .filter(p -> !p.getExpiryDate().isBefore(today)
                        && !p.getExpiryDate().isAfter(limit))
                .forEach(System.out::println);
    }

    // Policies by coverage type
    public void policiesByCoverage(String type) {
        hashSet.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    // Detect duplicate policy numbers from list
    public void findDuplicates(List<Policy> list) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : list) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        System.out.println("Duplicate Policy Numbers: " + duplicates);
    }

    // Display insertion order
    public void displayInsertionOrder() {
        linkedHashSet.forEach(System.out::println);
    }

    // Display sorted by expiry date
    public void displaySortedByExpiry() {
        treeSet.forEach(System.out::println);
    }

    // Performance comparison
    public void performanceTest(Policy samplePolicy) {

        testSetPerformance("HashSet", new HashSet<>(), samplePolicy);
        testSetPerformance("LinkedHashSet", new LinkedHashSet<>(), samplePolicy);
        testSetPerformance("TreeSet", new TreeSet<>(), samplePolicy);
    }

    private void testSetPerformance(String name, Set<Policy> set, Policy policy) {

        long startAdd = System.nanoTime();
        for (int i = 0; i < 10000; i++) set.add(policy);
        long endAdd = System.nanoTime();

        long startSearch = System.nanoTime();
        set.contains(policy);
        long endSearch = System.nanoTime();

        long startRemove = System.nanoTime();
        set.remove(policy);
        long endRemove = System.nanoTime();

        System.out.println("\n" + name + " Performance:");
        System.out.println("Add Time: " + (endAdd - startAdd));
        System.out.println("Search Time: " + (endSearch - startSearch));
        System.out.println("Remove Time: " + (endRemove - startRemove));
    }
}
