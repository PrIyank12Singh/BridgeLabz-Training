import java.util.*;

public class DataStructureSearchComparison {

    static void test(int n) {

        int target = n - 1;

        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>(n * 2);
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        System.out.println("Dataset Size: " + n);

        // Array Search
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) break;
        }
        long arrayTime = System.nanoTime() - start;

        // HashSet Search
        start = System.nanoTime();
        hashSet.contains(target);
        long hashSetTime = System.nanoTime() - start;

        // TreeSet Search
        start = System.nanoTime();
        treeSet.contains(target);
        long treeSetTime = System.nanoTime() - start;

        System.out.println("Array Search:   " + arrayTime / 1_000_000.0 + " ms");
        System.out.println("HashSet Search: " + hashSetTime / 1_000_000.0 + " ms");
        System.out.println("TreeSet Search: " + treeSetTime / 1_000_000.0 + " ms");
        System.out.println("    ");
    }

    public static void main(String[] args) {
        test(1_000);
        test(100_000);
        test(1_000_000);
    }
}
