import java.lang.reflect.Field;

public class JsonSerializationDemo {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    Object value = field.get(obj);

                    if (!first) {
                        json.append(", ");
                    }
                    json.append("\"").append(annotation.name()).append("\": ");
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    first = false;

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {

        User user = new User("Priyank", "priyank@example.com", 25);
        String json = toJson(user);

        System.out.println(json);
    }
}
