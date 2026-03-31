import java.util.*;

public class CorporateEmailAccessControlApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        String regex =
                "^[a-z]{3,}\\.[a-z]{3,}\\d{4,}@(sales|marketing|IT|product)\\.company\\.com$";

        while (n-- > 0) {

            String email = sc.nextLine().trim();

            if (email.matches(regex))
                System.out.println("Access Granted");
            else
                System.out.println("Access Denied");
        }
    }
}