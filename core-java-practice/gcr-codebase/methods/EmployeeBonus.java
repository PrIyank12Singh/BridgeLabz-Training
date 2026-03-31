import java.util.Random;

public class EmployeeBonus {

    // Method to generate salaries and years of service
    public static int[][] generateSalaryAndService(int n) {
        Random rand = new Random();
        int[][] data = new int[n][2]; // [salary, yearsOfService]

        for (int i = 0; i < n; i++) {
            // Generate 5-digit salary (10000 to 99999)
            data[i][0] = 10000 + rand.nextInt(90000);

            // Generate years of service (1 to 10)
            data[i][1] = 1 + rand.nextInt(10);
        }
        return data;
    }

    // Method to calculate new salary and bonus
    public static double[][] calculateNewSalaryAndBonus(int[][] data) {
        int n = data.length;
        double[][] result = new double[n][2]; // [newSalary, bonus]

        for (int i = 0; i < n; i++) {
            int salary = data[i][0];
            int years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;

            result[i][0] = newSalary;
            result[i][1] = bonus;
        }

        return result;
    }

    // Method to display salaries, bonus, totals
    public static void displayTable(int[][] data, double[][] result) {
        double totalOld = 0;
        double totalNew = 0;
        double totalBonus = 0;

        System.out.println("Emp\tOld Salary\tYears\tBonus\tNew Salary");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            int oldSalary = data[i][0];
            int years = data[i][1];
            double bonus = result[i][1];
            double newSalary = result[i][0];

            totalOld += oldSalary;
            totalNew += newSalary;
            totalBonus += bonus;

            System.out.printf("%d\t%d\t\t%d\t%.2f\t%.2f\n",
                    i + 1, oldSalary, years, bonus, newSalary);
        }

        System.out.println("-------------------------------------------------");
        System.out.printf("Total\t%.2f\t\t-\t%.2f\t%.2f\n",
                totalOld, totalBonus, totalNew);
    }

    // Main method
    public static void main(String[] args) {
        int number = 10;

        int[][] salaryAndService = generateSalaryAndService(number);
        double[][] newSalaryAndBonus = calculateNewSalaryAndBonus(salaryAndService);

        displayTable(salaryAndService, newSalaryAndBonus);
    }
}
