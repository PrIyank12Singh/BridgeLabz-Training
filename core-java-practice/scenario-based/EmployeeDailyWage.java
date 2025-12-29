import java.util.*;
public class EmployeeDailyWage {
  public static void main(String[] args) {
    
    int is_present = 1;
    int wage_per_hour = 20;
    int full_day_hours = 8;

    Random rand = new Random();
    int attendance = rand.nextInt(2); // 0 or 1

    int dailyWage = 0;

    if (attendance == is_present) {
      dailyWage = full_day_hours* wage_per_hour;
      System.out.println("Employee is Present");
    }

    else{
      System.out.println("Employee is Absent");
    }

    System.out.println("Daily Employee Wage: INR"+dailyWage );
  }
}
