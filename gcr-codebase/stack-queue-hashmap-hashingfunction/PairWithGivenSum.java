import java.util.*;

class PairWithGivenSum {

    public static boolean hasPair(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int needed = target - num;

            if (map.containsKey(needed)) {
                System.out.println("Pair found: " + needed + " + " + num + " = " + target);
                return true;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Taking input of array
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        boolean result = hasPair(arr, target);

        System.out.println(result ? "Yes" : "No");
        sc.close();
    }
}
