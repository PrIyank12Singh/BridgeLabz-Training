import java.util.*;

public class LinearBinarySearchChallenge {

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1, 7, 2};
        int target = 4;

        // linear search finds First missing positive integer
        int missing = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missing);

        // binary search finds index of target after sorting
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr); // Binary search requires sorted array
        int index = binarySearch(sortedArr, target);
        System.out.println("Index of target " + target + " in sorted array: " + index);

        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
    }

    // Linear Search: First missing positive
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Replace numbers <=0 or >n with n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        //  Mark numbers as visited by negating the index
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        //  Find first positive index
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // All numbers 1 to n are present
    }

    // Binary Search finds index of target
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }
}
