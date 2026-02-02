import java.util.HashMap;
import java.util.Map;

public class TestMapper {

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<>();
        data.put("id", 101);
        data.put("name", "Priyank");
        data.put("age", 22);

        Student student = ObjectMapperUtil.toObject(Student.class, data);
        student.display();
    }
}
