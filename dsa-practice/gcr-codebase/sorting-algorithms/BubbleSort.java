import java.util.Scanner;

public class BubbleSort {

    // Bubble Sort method
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swapping happened, array is already sorted
            if (!swapped) break;
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

        System.out.print("Enter number of students: ");
        int n = scan.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter student marks:");
        for (int i = 0; i < n; i++) {
            marks[i] = scan.nextInt();
        }

        System.out.println("Before Sorting:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("After Sorting (Ascending Order):");
        printArray(marks);

        scan.close();
    }
}
