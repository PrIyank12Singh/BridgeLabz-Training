package uc6.main;

import uc6.service.AdminService;
import java.util.Scanner;

public class AdminApp {
    public static void main(String[] args) {
        AdminService service = new AdminService();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== System Administration (UC-6) ===");
        System.out.print("Enter new specialty name to add: ");
        String specialty = sc.nextLine();

        if(service.addSpecialty(specialty)) {
            System.out.println("Specialty added successfully!");
        } else {
            System.out.println("Failed to add specialty. It may already exist.");
        }
    }
}
