

import java.util.*;

public class twoSum {

    public static int[] two_Sum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){

            int n1=nums[i];
            for(int j=0;j<nums.length;j++){
                
                int n2=nums[j];
                if(i!=j && n1+n2==target){
            
                    return new int[]{i,j};
                }

            }

        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int[] ans = two_Sum(nums, target);
        System.out.println(Arrays.toString(ans));

        sc.close();
    }
}

