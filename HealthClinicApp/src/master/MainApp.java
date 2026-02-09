package master;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n=== Health Clinic App ===");
            System.out.println("1. Patient Management (UC-1)");
            System.out.println("2. Doctor Management (UC-2)");
            System.out.println("3. Appointment Scheduling (UC-3)");
            System.out.println("4. Visit & Medical Records (UC-4)");
            System.out.println("5. Billing & Payments (UC-5)");
            System.out.println("6. System Administration (UC-6)");
            System.out.println("7. Exit");
            System.out.print("Select option: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    uc1.main.PatientManagementApp.main(new String[]{});
                    break;
                case 2:
                    uc2.main.DoctorManagementApp.main(new String[]{});
                    break;
                case 3:
                    uc3.main.AppointmentApp.main(new String[]{});
                    break;
                case 4:
                    uc4.main.VisitApp.main(new String[]{});
                    break;
                case 5:
                    uc5.main.BillingApp.main(new String[]{});
                    break;
                case 6:
                    uc6.main.AdminApp.main(new String[]{});
                    break;
                case 7:
                    System.out.println("Exiting Health Clinic App...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
