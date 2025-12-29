import java.util.Random;

public class EmployeeWageSwitchCase {
    public static void main(String[] args) {

        int is_absent = 0;
        int is_full_time = 1;
        int IS_PART_TIME = 2;

        int WAGE_PER_HOUR = 20;
        int FULL_TIME_HOURS = 8;
        int PART_TIME_HOURS = 8;

        Random random = new Random();
        int employeeType = random.nextInt(3); // 0,1,2

        int workingHours = 0;

        switch (employeeType) {

            case (is_full_time):
                workingHours = FULL_TIME_HOURS;
                System.out.println("Employee is FULL TIME");
                break;

            case IS_PART_TIME:
                workingHours = PART_TIME_HOURS;
                System.out.println("Employee is PART TIME");
                break;

            default:
                System.out.println("Employee is ABSENT");
        }

        int dailyWage = workingHours * WAGE_PER_HOUR;
        System.out.println("Daily Employee Wage: ₹" + dailyWage);
    }
}
