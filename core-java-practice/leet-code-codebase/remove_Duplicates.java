import java.util.*;

class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = sc.nextInt();

        if(n == 0){
            System.out.println("[]");
            sc.close();
            return;
        }

        int index = 1; // next position to insert unique number

        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i - 1]){
                nums[index] = nums[i];
                index++;
            }
        }

        // Print result
        System.out.print("[");
        for(int i = 0; i < index; i++){
            System.out.print(nums[i]);
            if(i != index - 1) System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}

