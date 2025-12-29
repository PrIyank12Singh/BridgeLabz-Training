public class EmployeeAttendace {
  public static void main(String[] args) {
    
    int attendance = (int) (Math.random()*2); //0 or 1

    if (attendance==1) {
      System.out.println("Employee is Present");
    }

    else{
      System.out.println("Employee is Absent");
    }
  }
}
