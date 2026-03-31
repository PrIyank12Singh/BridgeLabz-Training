import java.util.ArrayList;
import java.util.Random;

public class EmployeeWageComputationProgram {

    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;

    
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    
    static int getAttendance() {
        Random random = new Random();
        return random.nextInt(3); 
    }

    
    static int calculateWage(int hours) {
        return hours * WAGE_PER_HOUR;
    }

    public static void main(String[] args) {

    
        System.out.println("Welcome to Employee Wage Computation Program");

        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalWage = 0;

        ArrayList<Integer> dailyWages = new ArrayList<>();

      
        while (totalWorkingDays < MAX_WORKING_DAYS &&
              totalWorkingHours < MAX_WORKING_HOURS) {

            totalWorkingDays++;

            int hoursWorked = 0;
            int attendance = getAttendance();

          
            switch (attendance) {
                case 1:
                    hoursWorked = FULL_DAY_HOUR;
                    break;

                case 2:
                    hoursWorked = PART_TIME_HOUR;
                    break;

                default:
                    hoursWorked = 0; 
            }

            
            if (totalWorkingHours + hoursWorked > MAX_WORKING_HOURS) {
                hoursWorked = MAX_WORKING_HOURS - totalWorkingHours;
            }

            
            int dailyWage = calculateWage(hoursWorked);

            totalWorkingHours += hoursWorked;
            totalWage += dailyWage;
            dailyWages.add(dailyWage);

            System.out.println("Day " + totalWorkingDays +
                    " | Hours Worked: " + hoursWorked +
                    " | Daily Wage: " + dailyWage);
        }

        
    
        System.out.println("Total Working Days  : " + totalWorkingDays);
        System.out.println("Total Working Hours : " + totalWorkingHours);
        System.out.println("Total Monthly Wage  : " + totalWage);
    }
}
