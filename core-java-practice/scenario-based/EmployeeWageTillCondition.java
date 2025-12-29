import java.util.Random;

public class EmployeeWageTillCondition {
    public static void main(String[] args) {

        final int is_absent = 0;
        final int is_full_time = 1;
        final int is_part_time = 2;

        final int wage_per_hour = 20;
        final int full_time_hours = 8;
        final int part_time_hours = 8;

        final int max_working_days = 20;
        final int max_working_hours = 100;

        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalWage = 0;

        Random rand = new Random();

        // Continue until max days OR max hours is reached
        while (totalWorkingDays < max_working_days && totalWorkingHours < max_working_hours) {

            totalWorkingDays++;
            int employeeType = rand.nextInt(3);
            int workingHours = 0;

            if (employeeType == is_full_time) {
                workingHours = full_time_hours;
                System.out.println("Day " + totalWorkingDays + ": Full Time");
            }
            else if (employeeType == is_part_time) {
                workingHours = part_time_hours;
                System.out.println("Day " + totalWorkingDays + ": Part Time");
            }
            else {
                System.out.println("Day " + totalWorkingDays + ": Absent");
            }

            // Prevent exceeding max working hours
            if (totalWorkingHours + workingHours > max_working_hours) {
                workingHours = max_working_hours - totalWorkingHours;
            }

            totalWorkingHours += workingHours;
            int dailyWage = workingHours * wage_per_hour;
            totalWage += dailyWage;
        }

        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Employee Wage: INR" + totalWage);
    }
}
