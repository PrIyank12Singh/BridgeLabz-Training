import java.util.*;

public class bmi_Calculator {
  // Method to calculate BMI and return status
    public static String[] calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);
        String status = "";

        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";

        return new String[]{String.format("%.2f", weightKg),
                            String.format("%.2f", heightCm),
                            String.format("%.2f", bmi),
                            status};
    }

    // Method to process all team members
    public static String[][] processTeam(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            result[i] = calculateBMI(data[i][0], data[i][1]);
        }
        return result;
    }

    // Method to display the BMI table
    public static void displayBMI(String[][] bmiData) {

        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        System.out.println("--------------------------------------------------");
        for (String[] person : bmiData) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", person[0], person[1], person[2], person[3]);
        }
    }

    public static void main(String[] args) {
        //Taking input
        Scanner scan = new Scanner(System.in);
        double[][] teamData = new double[10][2];

        // Input weight and height for 10 members
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) of person " + (i + 1) + ":");
            teamData[i][0] = scan.nextDouble();
            System.out.println("Enter height (cm) of person " + (i + 1) + ":");
            teamData[i][1] = scan.nextDouble();
        }

        // Process and display results
        String[][] bmiResults = processTeam(teamData);
        displayBMI(bmiResults);
        scan.close();
      }
}
