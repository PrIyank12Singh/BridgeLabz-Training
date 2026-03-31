import java.util.*;

public class SortingComparison {

    // Bubble Sort 
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[l + x] = temp[x];
        }
    }

    // Quick Sort 
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    //  Testing 
    static void test(int n) {

        int[] base = new Random().ints(n, 0, n).toArray();

        System.out.println("Dataset size: " + n);

        // Bubble Sort (skip for large)
        if (n <= 10000) {
            int[] arr1 = base.clone();
            long start = System.nanoTime();
            bubbleSort(arr1);
            long time = System.nanoTime() - start;
            System.out.println("Bubble Sort: " + time / 1_000_000 + " ms");
        } else {
            System.out.println("Bubble Sort: Skipped (too slow)");
        }

        // Merge Sort
        int[] arr2 = base.clone();
        long start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        long time = System.nanoTime() - start;
        System.out.println("Merge Sort:  " + time / 1_000_000 + " ms");

        // Quick Sort
        int[] arr3 = base.clone();
        start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        time = System.nanoTime() - start;
        System.out.println("Quick Sort:  " + time / 1_000_000 + " ms");

        System.out.println("        ");
    }

    public static void main(String[] args) {
        test(1_000);
        test(10_000);
        test(1_000_000);
    }
}
