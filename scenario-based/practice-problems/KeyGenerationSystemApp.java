import java.util.*;

public class KeyGenerationSystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {

            String s = sc.nextLine();

            String validation = validate(s);

            if (validation != null) {
                System.out.println(validation);
            } else {
                String key = generateKey(s);
                System.out.println("The generated key is - " + key);
            }
        }
    }

    static String validate(String s) {

        if (s == null || s.length() == 0)
            return "Invalid Input (empty string)";

        if (s.length() < 6)
            return "Invalid Input (length < 6)";

        if (s.contains(" "))
            return "Invalid Input (contains space)";

        if (s.matches(".*\\d.*"))
            return "Invalid Input (contains digits)";

        if (!s.matches("[a-zA-Z]+"))
            return "Invalid Input (contains special character)";

        return null;
    }

    static String generateKey(String s) {

        s = s.toLowerCase();

        StringBuilder temp = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (((int) c) % 2 != 0)
                temp.append(c);
        }

        temp.reverse();

        for (int i = 0; i < temp.length(); i++) {
            if (i % 2 == 0)
                temp.setCharAt(i, Character.toUpperCase(temp.charAt(i)));
        }

        return temp.toString();
    }
}