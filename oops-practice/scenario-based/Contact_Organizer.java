import java.util.ArrayList;
import java.util.Scanner;

// Custom Exception
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

// Contact class
class Contact {
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits: " + phoneNumber);
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

// Contact Organizer
class ContactOrganizer {
    private ArrayList<Contact> contacts;

    // Constructor
    public ContactOrganizer() {
        contacts = new ArrayList<>();
    }

    // Add contact (prevent duplicate phone numbers)
    public void addContact(Contact contact) throws InvalidPhoneNumberException {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(contact.getPhoneNumber())) {
                throw new InvalidPhoneNumberException("Duplicate contact. Phone number already exists.");
            }
        }
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    // Delete by number
    public void deleteContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Search by name
    public void searchContact(String name) {
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + c.getName() + " - " + c.getPhoneNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with name: " + name);
        }
    }

    // Display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n  Contact List  ");
        for (Contact c : contacts) {
            System.out.println(c.getName() + " - " + c.getPhoneNumber());
        }
    }
}

// Main Application
public class Contact_Organizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactOrganizer organizer = new ContactOrganizer();

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter phone number: ");
                        String phone = sc.nextLine();

                        Contact contact = new Contact(name, phone);
                        organizer.addContact(contact);
                        break;

                    case 2:
                        System.out.print("Enter phone number to delete: ");
                        organizer.deleteContact(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter name to search: ");
                        organizer.searchContact(sc.nextLine());
                        break;

                    case 4:
                        organizer.displayContacts();
                        break;

                    case 5:
                        System.out.println("Exiting app.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (InvalidPhoneNumberException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
