import java.util.Scanner;

public class SelectionSort{

    // selection sort function 
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // moving boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {

            // assuming minimum index
            int minIndex = i;

            // finding minimum element in remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap found minimum with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter exam scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        selectionSort(scores);

        System.out.println("Sorted exam scores :");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        sc.close();
    }
}
