import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        //Function to check target from nums
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{ map.get(needed), i };
            }

            map.put(nums[i], i);
        }

        return new int[]{ -1, -1 }; // if no solution
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Taking input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //Taking target input
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        if (result[0] == -1) {
            System.out.println("No pair found");
        } else {
            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }
}
