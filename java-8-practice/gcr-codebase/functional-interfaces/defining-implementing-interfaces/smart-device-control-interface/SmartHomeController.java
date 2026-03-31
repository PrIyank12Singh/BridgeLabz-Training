import java.util.Scanner;

public class SmartHomeController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Device: 1.Light 2.AC 3.TV");
        int choice = sc.nextInt();

        SmartDevice device;

        switch (choice) {
            case 1:
                device = new SmartLight();
                break;
            case 2:
                device = new SmartAC();
                break;
            case 3:
                device = new SmartTV();
                break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        device.turnOn();
        device.turnOff();

        sc.close();
    }
}
