package uc1.main;

import uc1.model.Patient;
import uc1.service.PatientService;
import java.util.Scanner;

public class PatientManagementApp {
    public static void main(String[] args) {
        PatientService service = new PatientService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();
        System.out.print("Enter dob (YYYY-MM-DD): ");
        String dob = sc.nextLine();
        System.out.print("Enter contact: ");
        String contact = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter blood group: ");
        String bg = sc.nextLine();

        Patient p = new Patient(name,dob,contact,email,address,bg);
        if(service.addPatient(p)) System.out.println("Patient added with ID: "+p.getId());
    }
}
