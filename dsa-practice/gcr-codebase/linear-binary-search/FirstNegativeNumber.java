public class FirstNegativeNumber {

    public static void main(String[] args) {

        int[] arr = {3, 5, 0, 7, -2, 8, -1};

        int index = findFirstNegative(arr);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }

    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // return index of first negative number
            }
        }
        return -1; // no negative number found
    }
}
