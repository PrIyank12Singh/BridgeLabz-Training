public class DigitalWatch {
    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                System.out.printf("%02d:%02d\n", hour, minute);

                // Stop watch at 13:00 the power cut happens
                if (hour == 13 && minute == 0) {
                    System.out.println("Power Cut! Watch stopped.");
                    break;
                }
            }
            // outer loop
            if (hour == 13) {
                break;
            }
        }
    }
}
