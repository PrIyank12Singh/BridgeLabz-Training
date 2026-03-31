package presentation;

import service.AddressBookService;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("===== Address Book System =====");

        AddressBookService service = new AddressBookService();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {

            System.out.println("\n1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Add Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. View Persons By City");
            System.out.println("6. View Persons By State");
            System.out.println("7. Count By City");
            System.out.println("8. Count By State");
            System.out.println("9. Sort By Name");
            System.out.println("10. Sort By City");
            System.out.println("11. Sort By State");
            System.out.println("12. Sort By Zip");
            System.out.println("13. Save Contacts to JSON");
            System.out.println("14. Load Contacts from JSON");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> service.createAddressBook();
                case 2 -> service.selectAddressBook();
                case 3 -> service.addContactUsingConsole();
                case 4 -> service.displayContacts();
                case 5 -> service.viewPersonsByCity();
                case 6 -> service.viewPersonsByState();
                case 7 -> service.countByCity();
                case 8 -> service.countByState();
                case 9 -> service.sortByName();
                case 10 -> service.sortByCity();
                case 11 -> service.sortByState();
                case 12 -> service.sortByZip();
                case 13 -> service.saveContactsToJson();
                case 14 -> service.loadContactsFromJson();
                case 0 -> {
                    exit = true;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice!");
            }
        }

        scanner.close();
    }
}
