public class CsvStudentDuplicateRecord {

    private int id;
    private String name;
    private int age;
    private int marks;

    public CsvStudentDuplicateRecord(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void printRecord() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
    }
}
