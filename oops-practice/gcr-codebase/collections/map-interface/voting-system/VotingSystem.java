import java.util.*;

public class VotingSystem {

    private Map<String, Integer> votesHashMap = new HashMap<>();
    private Map<String, Integer> votesLinkedHashMap = new LinkedHashMap<>();

    // Add vote for a candidate
    public void vote(String candidate) {
        votesHashMap.put(candidate, votesHashMap.getOrDefault(candidate, 0) + 1);
        votesLinkedHashMap.put(candidate, votesLinkedHashMap.getOrDefault(candidate, 0) + 1);
    }

    // Display results in sorted order by candidate name using TreeMap
    public void displaySortedResults() {
        TreeMap<String, Integer> sorted = new TreeMap<>(votesHashMap);
        System.out.println("Results (Sorted by Candidate Name): " + sorted);
    }

    // Display results in insertion order (LinkedHashMap)
    public void displayInsertionOrderResults() {
        System.out.println("Results (Insertion Order): " + votesLinkedHashMap);
    }

    // Display total votes for each candidate (HashMap)
    public void displayAllVotes() {
        System.out.println("All votes (HashMap, unsorted): " + votesHashMap);
    }
}
