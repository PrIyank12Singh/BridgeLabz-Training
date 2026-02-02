public class CsvStudentMergedRecord {

    private int id;
    private String name;
    private int age;
    private int marks;
    private String grade;

    public CsvStudentMergedRecord(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    // Setters
    public void setMarks(int marks) { this.marks = marks; }
    public void setGrade(String grade) { this.grade = grade; }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public String toCsvRow() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }

    public void printRecord() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
        System.out.println("Grade : " + grade);
        System.out.println("----------------------");
    }
}
