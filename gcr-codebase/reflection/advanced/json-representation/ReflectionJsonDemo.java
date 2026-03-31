public class ReflectionJsonDemo {

    public static void main(String[] args) {

        StudentModel student =
                new StudentModel(101, "Priyank", 22);

        String json =
                ReflectionJsonUtil.convertToJson(student);

        System.out.println(json);
    }
}
