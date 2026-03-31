import java.util.Scanner;

public class LeaveManagementApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LeaveAdministrationService service = new LeaveAdministrationService();

        service.addStaffMember(new StaffMember(1, "Priyank", 10));
        service.addStaffMember(new StaffMember(2, "Rahul", 5));

        try {
            System.out.print("Enter Request ID: ");
            int reqId = sc.nextInt();

            System.out.print("Enter Staff ID: ");
            int staffId = sc.nextInt();

            System.out.print("Enter Number of Leave Days: ");
            int days = sc.nextInt();

            TimeOffRequest request =
                    new TimeOffRequest(reqId, staffId, days);

            service.applyLeave(request);

            System.out.println("Approve this leave? (yes/no)");
            String decision = sc.next();

            if (decision.equalsIgnoreCase("yes")) {
                service.approveLeave(reqId);
            } else {
                service.rejectLeave(reqId);
            }

            System.out.println("\nAll Leave Requests:");
            service.viewAllRequests();

        } catch (InsufficientLeaveBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
