import java.util.regex.*;

public class ValidateIP {
    public static void main(String[] args) {
        String ip = "192.168.0.1";
        String regex = "\\b((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\b";

        if (Pattern.matches(regex, ip)) {
            System.out.println(ip + " is a valid IPv4 address");
        } else {
            System.out.println(ip + " is invalid");
        }
    }
}
