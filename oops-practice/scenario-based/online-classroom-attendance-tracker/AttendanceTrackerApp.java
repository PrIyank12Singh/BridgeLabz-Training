import java.util.Scanner;

public class AttendanceTrackerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ClassroomAttendanceService service = new ClassroomAttendanceService();

        while (true) {

            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Remove Attendance");
            System.out.println("3. Display Session Attendance");
            System.out.println("4. Display All Sessions");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Session ID: ");
                    String sessionId = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentId = sc.nextLine();

                    try {
                        service.markAttendance(sessionId, studentId);
                    } catch (DuplicateAttendanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Session ID: ");
                    sessionId = sc.nextLine();

                    System.out.print("Enter Student ID: ");
                    studentId = sc.nextLine();

                    service.removeAttendance(sessionId, studentId);
                    break;

                case 3:
                    System.out.print("Enter Session ID: ");
                    sessionId = sc.nextLine();

                    service.displayAttendance(sessionId);
                    break;

                case 4:
                    service.displayAllSessions();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
