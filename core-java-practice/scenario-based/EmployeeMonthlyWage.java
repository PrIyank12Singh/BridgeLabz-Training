import java.util.Random;

public class EmployeeMonthlyWage{
    public static void main(String[] args) {

        final int is_absent = 0;
        final int is_full_time = 1;
        final int is_part_time = 2;

        final int wage_per_hour = 20;
        final int full_time_hours = 8;
        final int part_time_hours = 8;
        final int working_days = 20;

        int totalMonthlyWage = 0;
        Random rand = new Random();

        for (int day = 1; day <= working_days; day++) {

            int employeeType = rand.nextInt(3);
            int workingHours = 0;

            if (employeeType == is_full_time) {
                workingHours = full_time_hours;
                System.out.println("Day " + day + ": full time");
            }
            else if (employeeType == is_part_time) {
                workingHours = part_time_hours;
                System.out.println("Day " + day + ": part time");
            }
            else {
                System.out.println("Day " + day + ": absent");
            }

            int dailyWage = workingHours * wage_per_hour;
            totalMonthlyWage += dailyWage;
        }

        System.out.println("\nTotal Monthly Wage (20 Days): INR " + totalMonthlyWage);
    }
}
