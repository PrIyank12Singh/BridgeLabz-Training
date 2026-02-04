import java.util.*;

class ClassroomAttendanceService {

    // Map<SessionID, Set<StudentID>>
    private Map<String, Set<String>> attendanceMap = new HashMap<>();

    // Mark Attendance
    public void markAttendance(String sessionId, String studentId)
            throws DuplicateAttendanceException {

        attendanceMap.putIfAbsent(sessionId, new HashSet<>());

        Set<String> students = attendanceMap.get(sessionId);

        if (students.contains(studentId)) {
            throw new DuplicateAttendanceException(
                    "Attendance already marked for Student ID: " + studentId);
        }

        students.add(studentId);
        System.out.println("Attendance marked successfully.");
    }

    // Remove Attendance
    public void removeAttendance(String sessionId, String studentId) {

        if (!attendanceMap.containsKey(sessionId)) {
            System.out.println("Session not found.");
            return;
        }

        Set<String> students = attendanceMap.get(sessionId);

        if (students.remove(studentId)) {
            System.out.println("Attendance removed successfully.");
        } else {
            System.out.println("Student not found in this session.");
        }
    }

    // Display Attendance for a Session
    public void displayAttendance(String sessionId) {

        if (!attendanceMap.containsKey(sessionId)) {
            System.out.println("Session not found.");
            return;
        }

        Set<String> students = attendanceMap.get(sessionId);

        if (students.isEmpty()) {
            System.out.println("No students attended this session.");
        } else {
            System.out.println("Attendance for Session " + sessionId + ":");
            for (String student : students) {
                System.out.println(student);
            }
        }
    }

    // Display All Sessions
    public void displayAllSessions() {

        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance records available.");
            return;
        }

        for (Map.Entry<String, Set<String>> entry : attendanceMap.entrySet()) {
            System.out.println("Session ID: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
            System.out.println();
        }
    }
}
