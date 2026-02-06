
public class TimeOffRequest {
    private int requestId;
    private int staffId;
    private int numberOfDays;
    private String status; // PENDING, APPROVED, REJECTED

    public TimeOffRequest(int requestId, int staffId, int numberOfDays) {
        this.requestId = requestId;
        this.staffId = staffId;
        this.numberOfDays = numberOfDays;
        this.status = "PENDING";
    }

    public int getRequestId() {
        return requestId;
    }

    public int getStaffId() {
        return staffId;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request ID: " + requestId +
               ", Staff ID: " + staffId +
               ", Days: " + numberOfDays +
               ", Status: " + status;
    }
}
