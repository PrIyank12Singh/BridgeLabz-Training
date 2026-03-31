import java.util.Scanner;

public class QuickSort {

    // Partition method
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);   // left part
            quickSort(arr, pi + 1, high);  // right part
        }
    }

    // Print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = scan.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }

        System.out.println("Before Sorting:");
        printArray(prices);

        quickSort(prices, 0, n - 1);

        System.out.println("After Sorting :");
        printArray(prices);

        scan.close();
    }
}
