import java.util.*;

class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        //Taking sum initially 0
        int sum = 0;

        // Subarray starting from index 0
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) {

                for (int startIndex : map.get(sum)) {
                    System.out.println("Subarray from " + (startIndex + 1) + " to " + i);
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Taking Input
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findZeroSumSubarrays(arr);

        sc.close();
    }
}
