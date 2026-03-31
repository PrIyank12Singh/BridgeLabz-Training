abstract class Course {

    private String courseName;
    private int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    protected void displayBasicInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }

    //each course details 
    public abstract void displayCourseDetails();
}

// online course is a course
class OnlineCourse extends Course {

    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName,
                        int duration,
                        String platform,
                        boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    protected void displayOnlineInfo() {
        displayBasicInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }

    @Override
    public void displayCourseDetails() {
        displayOnlineInfo();
        System.out.println("Course Type: Online");
    }
}

// paidOnlineCourse is a OnlineCourse
class PaidOnlineCourse extends OnlineCourse {

    private double fee;
    private double discount; // percentage

    public PaidOnlineCourse(String courseName,
                            int duration,
                            String platform,
                            boolean isRecorded,
                            double fee,
                            double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayCourseDetails() {
        super.displayOnlineInfo();
        System.out.println("Fee: INR " + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: INR " + (fee - (fee * discount / 100)));
        System.out.println("Course Type: Paid Online");
    }
}

// main class
public class EducationalCourseHierarchy {

    public static void main(String[] args) {

        Course freeCourse = new OnlineCourse(
                "Java Basics",
                40,
                "GFG",
                true
        );

        Course paidCourse = new PaidOnlineCourse(
                "Advanced Java",
                60,
                "ProPeers",
                true,
                5000,
                20
        );

        freeCourse.displayCourseDetails();
        System.out.println();

        paidCourse.displayCourseDetails();
    }
}
