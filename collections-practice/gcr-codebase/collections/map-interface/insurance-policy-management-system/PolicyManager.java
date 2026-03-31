import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy p) {
        hashMap.put(p.getPolicyNumber(), p);
        linkedHashMap.put(p.getPolicyNumber(), p);

        treeMap.computeIfAbsent(p.getExpiryDate(), k -> new ArrayList<>()).add(p);
    }

    // Retrieve by policy number
    public Policy getPolicy(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // List all policies expiring within next 30 days
    public List<Policy> policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        List<Policy> result = new ArrayList<>();

        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(today, true, limit, true).entrySet()) {
            result.addAll(entry.getValue());
        }

        return result;
    }

    // List all policies for a specific policyholder
    public List<Policy> policiesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashMap.values()) {
            if (p.getPolicyHolder().equalsIgnoreCase(holder)) {
                result.add(p);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpired() {
        LocalDate today = LocalDate.now();

        // Remove from HashMap and LinkedHashMap
        hashMap.values().removeIf(p -> p.getExpiryDate().isBefore(today));
        linkedHashMap.values().removeIf(p -> p.getExpiryDate().isBefore(today));

        // Remove from TreeMap
        treeMap.headMap(today).clear();
    }

    // Display all policies in HashMap
    public void displayAllHashMap() {
        hashMap.values().forEach(System.out::println);
    }

    // Display all policies in LinkedHashMap (insertion order)
    public void displayAllLinkedHashMap() {
        linkedHashMap.values().forEach(System.out::println);
    }

    // Display policies sorted by expiry date
    public void displayAllTreeMap() {
        treeMap.values().forEach(list -> list.forEach(System.out::println));
    }
}
