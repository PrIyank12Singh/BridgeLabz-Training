import java.util.Scanner;

class remove_element {
    public int removeElement(int[] nums, int val) {
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
      int n = sc.nextInt();
      int[] nums= new int[n];
      int val = sc.nextInt();

      for (int i = 0; i < nums.length; i++) {
        nums[i] = sc.nextInt();
      }

      int answer = removeElement( nums[],val)
      sc.close();
    }
}