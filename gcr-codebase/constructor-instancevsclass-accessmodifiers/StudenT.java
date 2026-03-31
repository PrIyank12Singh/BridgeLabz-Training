class StudenT {
    public int rollNumber;
    protected String name;
    private double cgpa;

    //Parameterized Constructor
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class PostgraduateStudent extends StudenT {
    void display() {
        System.out.println(rollNumber + " " + name);
    }
}
