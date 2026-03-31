import java.util.*;

public class SearchComparison {

    // Linear Search 
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search 
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    static void test(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = i;

        int target = n - 1; // worst case

        // Linear Search
        long start = System.nanoTime();
        linearSearch(data, target);
        long linearTime = System.nanoTime() - start;

        // Sort for Binary Search
        Arrays.sort(data);

        // Binary Search
        start = System.nanoTime();
        binarySearch(data, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("N = " + n);
        System.out.println("Linear Search:  " + linearTime / 1_000_000.0 + " ms");
        System.out.println("Binary Search:  " + binaryTime / 1_000_000.0 + " ms");
        System.out.println("      ");
    }

    public static void main(String[] args) {
        test(1_000);
        test(10_000);
        test(1_000_000);
    }
}
