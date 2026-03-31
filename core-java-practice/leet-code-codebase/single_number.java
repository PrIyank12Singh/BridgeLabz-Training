import java.util.*;

class single_number {

    // Make method static OR create object
    public static int singleNumber(int[] nums) {
        int res = 0;

        for (int n : nums) {
            res ^= n;
        }

        return res;        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int result = singleNumber(nums);
        System.out.println(result);   // print answer

        sc.close();
    }
}
