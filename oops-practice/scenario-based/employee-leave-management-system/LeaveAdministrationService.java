
import java.util.*;

public class LeaveAdministrationService {

    private Map<Integer, StaffMember> staffMap = new HashMap<>();
    private List<TimeOffRequest> requestList = new ArrayList<>();

    // Add employee
    public void addStaffMember(StaffMember staff) {
        staffMap.put(staff.getStaffId(), staff);
    }

    // Apply Leave
    public void applyLeave(TimeOffRequest request)
            throws InsufficientLeaveBalanceException {

        StaffMember staff = staffMap.get(request.getStaffId());

        if (staff == null) {
            System.out.println("Staff not found.");
            return;
        }

        if (staff.getLeaveBalance() < request.getNumberOfDays()) {
            throw new InsufficientLeaveBalanceException(
                    "Not enough leave balance for Staff ID: " + staff.getStaffId());
        }

        requestList.add(request);
        System.out.println("Leave request submitted successfully.");
    }

    // Approve Leave
    public void approveLeave(int requestId)
            throws InsufficientLeaveBalanceException {

        for (TimeOffRequest request : requestList) {
            if (request.getRequestId() == requestId &&
                request.getStatus().equals("PENDING")) {

                StaffMember staff = staffMap.get(request.getStaffId());

                if (staff.getLeaveBalance() < request.getNumberOfDays()) {
                    throw new InsufficientLeaveBalanceException(
                            "Insufficient leave at approval time.");
                }

                staff.setLeaveBalance(
                        staff.getLeaveBalance() - request.getNumberOfDays());

                request.setStatus("APPROVED");
                System.out.println("Leave Approved.");
                return;
            }
        }

        System.out.println("Request not found or already processed.");
    }

    // Reject Leave
    public void rejectLeave(int requestId) {
        for (TimeOffRequest request : requestList) {
            if (request.getRequestId() == requestId &&
                request.getStatus().equals("PENDING")) {

                request.setStatus("REJECTED");
                System.out.println("Leave Rejected.");
                return;
            }
        }

        System.out.println("Request not found or already processed.");
    }

    // View All Requests
    public void viewAllRequests() {
        for (TimeOffRequest request : requestList) {
            System.out.println(request);
        }
    }
}
