package uc4.main;

import uc4.model.Visit;
import uc4.model.Prescription;
import uc4.service.VisitService;

import java.time.LocalDate;
import java.util.Scanner;

public class VisitApp {
    public static void main(String[] args) {
        VisitService service = new VisitService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter appointment ID: ");
        int aid = sc.nextInt();
        System.out.print("Enter doctor ID: ");
        int did = sc.nextInt();
        System.out.print("Enter patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter diagnosis: ");
        sc.nextLine(); // consume newline
        String diag = sc.nextLine();
        System.out.print("Enter notes: ");
        String notes = sc.nextLine();

        Visit v = new Visit(aid, did, pid, LocalDate.now(), diag, notes);
        if(service.addVisit(v)) System.out.println("Visit added with ID: " + v.getId());

        System.out.print("Add prescription? (yes/no): ");
        String ans = sc.next();
        if(ans.equalsIgnoreCase("yes")) {
            sc.nextLine();
            System.out.print("Medicine: ");
            String med = sc.nextLine();
            System.out.print("Dose: ");
            String dose = sc.nextLine();
            System.out.print("Duration: ");
            String dur = sc.nextLine();

            Prescription p = new Prescription(v.getId(), med, dose, dur);
            if(service.addPrescription(p)) System.out.println("Prescription added with ID: " + p.getId());
        }
    }
}
