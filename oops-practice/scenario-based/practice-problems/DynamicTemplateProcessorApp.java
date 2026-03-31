import java.util.*;
import java.util.regex.*;

public class DynamicTemplateProcessorApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Pattern pattern = Pattern.compile("\\$\\{([^:]+):([^}]+)\\}");

        while (n-- > 0) {

            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            StringBuffer result = new StringBuffer();

            while (matcher.find()) {

                String type = matcher.group(1);
                String value = matcher.group(2);

                String replacement = process(type, value);

                matcher.appendReplacement(result, replacement);
            }

            matcher.appendTail(result);

            System.out.println(result.toString());
        }
    }

    static String process(String type, String val) {

        switch (type) {

            case "UPPER":
                return val.toUpperCase();

            case "LOWER":
                return val.toLowerCase();

            case "DATE":
                return formatDate(val);

            case "REPEAT":
                return repeatWord(val);

            default:
                return "INVALID";
        }
    }

    static String formatDate(String d) {

        if (!d.matches("\\d{2}-\\d{2}-\\d{4}"))
            return "INVALID";

        String[] p = d.split("-");
        int day = Integer.parseInt(p[0]);
        int month = Integer.parseInt(p[1]);
        int year = Integer.parseInt(p[2]);

        if (month < 1 || month > 12)
            return "INVALID";

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            days[1] = 29;

        if (day < 1 || day > days[month - 1])
            return "INVALID";

        return year + "/" + String.format("%02d", month) +
                "/" + String.format("%02d", day);
    }

    static String repeatWord(String val) {

        String[] p = val.split(",");

        if (p.length != 2)
            return "INVALID";

        String word = p[0];

        int count;

        try {
            count = Integer.parseInt(p[1]);
        } catch (Exception e) {
            return "INVALID";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++)
            sb.append(word);

        return sb.toString();
    }
}