import java.util.*;
import java.util.regex.*;

public class ExpressionTagScoringEngineApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String line = sc.nextLine();
            System.out.println(evaluate(line));
        }
    }

    static String evaluate(String input) {

        Pattern validTag = Pattern.compile(
                "\\[(SUM|MUL|MAX|MIN):(-?(0|[1-9]\\d*)(,-?(0|[1-9]\\d*))+)\\]"
        );

        Matcher m = validTag.matcher(input);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {

            String op = m.group(1);
            String expr = m.group(2);

            int result = compute(op, expr);

            m.appendReplacement(sb, String.valueOf(result));
        }

        m.appendTail(sb);

        // Now handle malformed / broken tags
        String processed = sb.toString();
        processed = processed.replaceAll("\\[[^\\]]*$", "ERROR"); // broken open
        processed = processed.replaceAll("\\[[^\\]]*\\]", "ERROR"); // invalid tag

        return processed;
    }

    static int compute(String op, String expr) {

        String[] nums = expr.split(",");

        int res;

        switch (op) {

            case "SUM":
                res = 0;
                for (String s : nums) res += Integer.parseInt(s);
                return res;

            case "MUL":
                res = 1;
                for (String s : nums) res *= Integer.parseInt(s);
                return res;

            case "MAX":
                res = Integer.MIN_VALUE;
                for (String s : nums)
                    res = Math.max(res, Integer.parseInt(s));
                return res;

            case "MIN":
                res = Integer.MAX_VALUE;
                for (String s : nums)
                    res = Math.min(res, Integer.parseInt(s));
                return res;
        }
        return 0;
    }
}