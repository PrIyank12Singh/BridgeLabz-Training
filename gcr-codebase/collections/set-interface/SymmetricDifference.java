import java.util.*;

public class SymmetricDifference {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> result = new HashSet<>(set1);

        // add elements not in set1
        for (int x : set2) {
            if (!set1.contains(x)) {
                result.add(x);
            }
        }

        // remove common elements
        for (int x : set1) {
            if (set2.contains(x)) {
                result.remove(x);
            }
        }

        System.out.println(result);
    }
}
