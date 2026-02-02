public class JsonManualStudentRecord {

    private int id;
    private String name;
    private int age;
    private int marks;

    public JsonManualStudentRecord(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toCsvRow() {
        return id + "," + name + "," + age + "," + marks;
    }

    public String toJsonString() {
        return String.format("{\"id\":%d,\"name\":\"%s\",\"age\":%d,\"marks\":%d}", id, name, age, marks);
    }

    public static JsonManualStudentRecord fromCsvRow(String row) {
        String[] data = row.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        int age = Integer.parseInt(data[2]);
        int marks = Integer.parseInt(data[3]);
        return new JsonManualStudentRecord(id, name, age, marks);
    }
}
