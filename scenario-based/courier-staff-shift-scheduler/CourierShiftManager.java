import java.util.*;

public class CourierShiftManager {

    private List<CourierEmployee> employeeList;
    private Map<DeliveryShiftTime, List<CourierEmployee>> shiftAllocationMap;

    public CourierShiftManager() {
        employeeList = new ArrayList<>();
        shiftAllocationMap = new HashMap<>();

        for (DeliveryShiftTime shift : DeliveryShiftTime.values()) {
            shiftAllocationMap.put(shift, new ArrayList<>());
        }
    }

    public void addEmployee(CourierEmployee employee) {
        employeeList.add(employee);
    }

    public void assignShift(int employeeId, DeliveryShiftTime shift)
            throws ShiftAlreadyAssignedException {

        CourierEmployee employee = findEmployeeById(employeeId);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        if (employee.getAssignedShifts().contains(shift)) {
            throw new ShiftAlreadyAssignedException(
                    "Employee already assigned to " + shift + " shift.");
        }

        employee.addShift(shift);
        shiftAllocationMap.get(shift).add(employee);

        System.out.println("Shift assigned successfully.");
    }

    private CourierEmployee findEmployeeById(int employeeId) {
        for (CourierEmployee employee : employeeList) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void displayShiftSchedule() {
        for (DeliveryShiftTime shift : shiftAllocationMap.keySet()) {
            System.out.println("\n" + shift + " Shift:");

            List<CourierEmployee> employees = shiftAllocationMap.get(shift);

            if (employees.isEmpty()) {
                System.out.println("No employees assigned.");
            } else {
                for (CourierEmployee employee : employees) {
                    System.out.println("ID: " + employee.getEmployeeId() +
                            ", Name: " + employee.getEmployeeName());
                }
            }
        }
    }
}
