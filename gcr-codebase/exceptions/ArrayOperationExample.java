import java.util.Scanner;

public class ArrayOperationExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer[] arr = null;   // change to new Integer[]{...} to test valid case

        try {
            // Uncomment below to test valid array
            System.out.print("Enter array size: ");
            int size = sc.nextInt();

            arr = new Integer[size];

            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter index: ");
            int index = sc.nextInt();

            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");

        } finally {
            sc.close();
        }
    }
}
