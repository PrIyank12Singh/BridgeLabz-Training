import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative
    public static boolean isPalindromeIterative(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Logic 3: Using char array
    public static boolean isPalindromeArray(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scan.nextLine();

        System.out.println("Palindrome Check (Iterative): " + isPalindromeIterative(text));
        System.out.println("Palindrome Check (Recursive): " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Palindrome Check (Char Array): " + isPalindromeArray(text));

        scan.close();
    }
}
