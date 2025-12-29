
public class DigitalWatch {
    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {

              //Printing in formatting manner
                System.out.printf("%02d:%02d\n", hour, minute);

                if (hour == 13 && minute == 0) {
                    System.out.println("Power Cut! Watch stopped.");
                    break;
                }
            }

            if (hour == 13) {
                break;
            }
        }
    }
}
