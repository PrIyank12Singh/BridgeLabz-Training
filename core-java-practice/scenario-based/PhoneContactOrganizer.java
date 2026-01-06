import java.util.*;

// custom Exception
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
// contact class
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
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
//contact Organizer
class ContactOrganizer {

    private List<Contact> contacts = new ArrayList<>();

    // Validate phone number
    private void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberException {

        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                "Phone number must be exactly 10 digits"
            );
        }
    }

    // add contact
    public void addContact(String name, String phone)
            throws InvalidPhoneNumberException {

        validatePhoneNumber(phone);

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Duplicate contact");
                return;
            }
        }

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added");
    }

    // Delete contact
    public void deleteContact(String phone) {
        Iterator<Contact> it = contacts.iterator();

        while (it.hasNext()) {
            if (it.next().getPhoneNumber().equals(phone)) {
                it.remove();
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // Search contact
    public void searchContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Name: " + c.getName());
                System.out.println("Phone: " + c.getPhoneNumber());
                return;
            }
        }
        System.out.println("Contact not found");
    }
}

// Main class
public class PhoneContactOrganizer {

    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Ansh", "9876543210");
            organizer.addContact("Naman", "9876543210"); // duplicate
            organizer.addContact("Neha", "12345");      // invalid

        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        organizer.searchContact("9876543210");
        organizer.deleteContact("9876543210");
        organizer.searchContact("9876543210");
    }
}
