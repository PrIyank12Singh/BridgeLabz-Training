import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String ssn = "123-45-6789";
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        if (Pattern.matches(regex, ssn)) {
            System.out.println(ssn + " is valid");
        } else {
            System.out.println(ssn + " is invalid");
        }
    }
}
