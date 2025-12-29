import java.util.Random;

public class EmployeeWageSwitchCase {
    public static void main(String[] args) {

        final int is_absent = 0;
        final int is_full_time = 1;
        final int is_part_time = 2;

        final int wage_per_hour = 20;
        final int full_time_hours = 8;
        final int part_time_hours = 8;

        Random rand = new Random();
        int employeeType = rand.nextInt(3);   // 0,1,2

        int workingHours = 0;

        switch (employeeType) {

            case is_full_time:
                workingHours = full_time_hours;
                System.out.println("Employee is Full Time");
                break;

            case is_part_time:
                workingHours = part_time_hours;
                System.out.println("Employee is part time");
                break;

            case is_absent:
            default:
                System.out.println("Employee is Absent");
        }

        int dailyWage = workingHours * wage_per_hour;
        System.out.println("Daily Employee Wage: INR" + dailyWage);
    }
}
