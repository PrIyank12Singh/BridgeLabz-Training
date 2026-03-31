
public class StaffMember {
    private int staffId;
    private String name;
    private int leaveBalance;

    public StaffMember(int staffId, String name, int leaveBalance) {
        this.staffId = staffId;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    @Override
    public String toString() {
        return "ID: " + staffId +
               ", Name: " + name +
               ", Leave Balance: " + leaveBalance;
    }
}
