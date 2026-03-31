import java.util.HashSet;
import java.util.Set;
public class CourierEmployee {

    private int employeeId;
    private String employeeName;
    private Set<DeliveryShiftTime> assignedShifts;

    public CourierEmployee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.assignedShifts = new HashSet<>();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Set<DeliveryShiftTime> getAssignedShifts() {
        return assignedShifts;
    }

    public void addShift(DeliveryShiftTime shift) {
        assignedShifts.add(shift);
    }
}
