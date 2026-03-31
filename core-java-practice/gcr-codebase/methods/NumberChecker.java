import java.util.Scanner;

public class NumberChecker {

    // Method to count digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store digits in array
    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to check Duck Number
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check Armstrong Number
    public static boolean isArmstrong(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // Method to find smallest and second smallest
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    // Main Method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        int number = input.nextInt();

        int digitCount = countDigits(number);
        int[] digits = getDigitsArray(number);

        System.out.println("Digit Count: " + digitCount);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Duck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong Number: " + isArmstrong(number, digits));

        int[] large = findLargestAndSecondLargest(digits);
        System.out.println("Largest: " + large[0]);
        System.out.println("Second Largest: " + large[1]);

        int[] small = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + small[0]);
        System.out.println("Second Smallest: " + small[1]);

        input.close();
    }
}
