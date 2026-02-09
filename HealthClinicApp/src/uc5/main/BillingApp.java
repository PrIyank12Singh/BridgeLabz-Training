package uc5.main;

import uc5.model.Bill;
import uc5.service.BillingService;

import java.util.List;
import java.util.Scanner;

public class BillingApp {
    public static void main(String[] args) {
        BillingService service = new BillingService();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n=== Billing Menu ===");
            System.out.println("1. Add Bill");
            System.out.println("2. Show All Bills");
            System.out.println("3. Mark Bill as Paid");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter visit ID: ");
                    int vid = sc.nextInt();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    Bill b = new Bill(vid, amt, "PENDING");
                    if(service.addBill(b)) System.out.println("Bill added with ID: " + b.getId());
                    break;
                case 2:
                    List<Bill> bills = service.getAllBills();
                    for(Bill bill : bills) {
                        System.out.println("ID: " + bill.getId() + ", VisitID: " + bill.getVisitId() +
                                ", Amount: " + bill.getAmount() + ", Status: " + bill.getStatus());
                    }
                    break;
                case 3:
                    System.out.print("Enter bill ID to mark as PAID: ");
                    int bid = sc.nextInt();
                    if(service.markPaid(bid)) System.out.println("Bill marked as PAID");
                    else System.out.println("Bill not found");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
