import java.util.Random;

public class FootballTeamHeights {

    // Method to find sum of heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    // Method to find mean height
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] heights = new int[11]; // football team size = 11
        Random random = new Random();

        // Generate random heights between 150 cm and 250 cm
        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(101) + 150;
        }

        // Display heights
        
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();

        // Calculations
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        double mean = findMean(heights);

        // Display results
        System.out.println("Shortest Height : " + shortest + " cm");
        System.out.println("Tallest Height  : " + tallest + " cm");
        System.out.println("Mean Height     : " + mean + " cm");
    }
}
