package uc2.main;

import uc2.model.Doctor;
import uc2.service.DoctorService;

import java.util.Scanner;

public class DoctorManagementApp {
    public static void main(String[] args) {
        DoctorService service = new DoctorService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter doctor name: ");
        String name = sc.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();
        System.out.print("Enter contact: ");
        String contact = sc.nextLine();
        System.out.print("Enter consultation fee: ");
        double fee = sc.nextDouble();

        Doctor d = new Doctor(name, specialization, contact, fee);
        if(service.addDoctor(d)) System.out.println("Doctor added with ID: "+d.getId());
    }
}
