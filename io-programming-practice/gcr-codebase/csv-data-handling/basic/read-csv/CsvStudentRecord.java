public class CsvStudentRecord {

    private int id;
    private String name;
    private int age;
    private int marks;

    public CsvStudentRecord(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public void printRecord() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Marks : " + marks);
        System.out.println("----------------------");
    }
}
