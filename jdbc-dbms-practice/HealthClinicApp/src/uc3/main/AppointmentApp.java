package uc3.main;

import uc3.model.Appointment;
import uc3.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AppointmentApp {
    public static void main(String[] args) {
        AppointmentService service = new AppointmentService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter doctor ID: ");
        int did = sc.nextInt();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.next());
        System.out.print("Enter appointment time (HH:MM): ");
        LocalTime time = LocalTime.parse(sc.next());

        Appointment appt = new Appointment(pid, did, date, time);
        if(service.addAppointment(appt)) System.out.println("Appointment scheduled with ID: "+appt.getId());
    }
}
