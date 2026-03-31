import java.util.Scanner;
public class CourierShiftApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CourierShiftManager manager = new CourierShiftManager();

        // Adding sample employees
        manager.addEmployee(new CourierEmployee(1, "Rahul"));
        manager.addEmployee(new CourierEmployee(2, "Anita"));
        manager.addEmployee(new CourierEmployee(3, "Vikram"));

        try {
            manager.assignShift(1, DeliveryShiftTime.MORNING);
            manager.assignShift(2, DeliveryShiftTime.AFTERNOON);
            manager.assignShift(1, DeliveryShiftTime.MORNING); // duplicate
        } catch (ShiftAlreadyAssignedException e) {
            System.out.println(e.getMessage());
        }

        manager.displayShiftSchedule();

        scanner.close();
    }
}
