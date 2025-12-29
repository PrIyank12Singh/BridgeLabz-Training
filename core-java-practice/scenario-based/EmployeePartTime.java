import java.util.Random;

public class EmployeePartTime {
    public static void main(String[] args) {

        int is_absent= 0;
        int is_full_time = 1;
        int is_part_time = 2;

        int wage_per_hour = 20;
        int full_time_hours = 8;
        int part_time_hours = 8; // Assuming

        Random rand = new Random();
        int employeeType = rand.nextInt(3); // 0, 1, 2

        int workingHours = 0;
        int dailyWage = 0;

        if (employeeType == is_full_time) {
            workingHours = full_time_hours;
            System.out.println("Employee is Full Time");
        } 
        else if (employeeType == is_part_time) {
            workingHours = part_time_hours;
            System.out.println("Employee is Part Time");
        } 
        else {
            System.out.println("Employee is Absent");
        }

        dailyWage = workingHours *wage_per_hour;
        System.out.println("Daily Employee Wage: INR "+dailyWage);
    }
}
