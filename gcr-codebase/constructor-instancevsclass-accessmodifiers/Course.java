class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "BridgeLabz";

    //Parameterized Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println(courseName + " " + duration + " " + fee);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }
}
