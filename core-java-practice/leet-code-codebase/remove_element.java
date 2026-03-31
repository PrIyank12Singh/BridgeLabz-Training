import java.util.Scanner;

class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();          // size of array
        int[] nums = new int[n];

        int val = sc.nextInt();        // value to remove

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int answer = removeElement(nums, val);

        

        System.out.println(answer);   //length after removing

        sc.close();
    }
}
