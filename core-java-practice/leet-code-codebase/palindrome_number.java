import java.util.Scanner;

class palindrome_number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int xcopy = x;

        while (x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return reverse == xcopy;        
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();

      int isBoolean = isPalindrome(x);

      System.out.println(isBoolean);
      sc.close();
    }
}