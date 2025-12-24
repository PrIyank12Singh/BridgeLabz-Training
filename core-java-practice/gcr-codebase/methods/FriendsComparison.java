import java.util.Scanner;

public class FriendsComparison {

    public static int findYoungest(int[] ages) {
      //checking youngest between 3  
      int min = ages[0];
        for (int age : ages) {
            if (age < min)
                min = age;
        }
        return min;
    }

    public static double findTallest(double[] heights) {
      //checking who is tallest between 3  
      double max = heights[0];
        for (double h : heights) {
            if (h > max)
                max = h;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //taking ages and heights as a input
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            ages[i] = scan.nextInt();
            heights[i] = scan.nextDouble();
        }

        System.out.println("Youngest Age: " + findYoungest(ages));
        System.out.println("Tallest Height: " + findTallest(heights));

        scan.close();
    }
}
