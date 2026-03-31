import java.lang.reflect.Field;

public class ReflectionJsonUtil {

    public static String convertToJson(Object obj) {

        StringBuilder json = new StringBuilder();
        Class<?> cls = obj.getClass();

        json.append("{");

        Field[] fields = cls.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            try {
                json.append("\"")
                    .append(field.getName())
                    .append("\": ");

                Object value = field.get(obj);

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}
