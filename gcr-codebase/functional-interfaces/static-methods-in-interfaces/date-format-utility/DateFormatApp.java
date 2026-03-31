import java.time.LocalDate;

public class DateFormatApp {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        String format1 = DateUtils.formatDate(today, "dd/MM/yyyy");
        String format2 = DateUtils.formatDate(today, "MMMM dd, yyyy");
        String format3 = DateUtils.formatDate(today, "yyyy-MM-dd");

        System.out.println("Formatted Dates:");
        System.out.println("dd/MM/yyyy -> " + format1);
        System.out.println("MMMM dd, yyyy -> " + format2);
        System.out.println("yyyy-MM-dd -> " + format3);
    }
}
