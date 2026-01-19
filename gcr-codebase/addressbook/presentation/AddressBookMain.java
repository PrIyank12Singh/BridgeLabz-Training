import addressbook.model.Contact;
import addressbook.service.AddressBookService;
import java.util.*;


public class AddressBookMain {


private static Scanner scanner = new Scanner(System.in);
private static AddressBookService service = new AddressBookService();


public static void main(String[] args) {
System.out.println("Welcome to Address Book Program");


service.createAddressBook("Default");


while (true) {
System.out.println("\n1.Add Contact 2.Delete Contact 3.Search 4.Count 5.Exit");
int choice = scanner.nextInt();
scanner.nextLine();


switch (choice) {
case 1 -> addContact();
case 2 -> deleteContact();
case 3 -> search();
case 4 -> count();
case 5 -> System.exit(0);
default -> System.out.println("Invalid choice");
}
}
}


private static void addContact() {
System.out.print("First Name: ");
String fn = scanner.nextLine();
System.out.print("Last Name: ");
String ln = scanner.nextLine();
System.out.print("Address: ");
String addr = scanner.nextLine();
System.out.print("City: ");
String city = scanner.nextLine();
System.out.print("State: ");
String state = scanner.nextLine();
System.out.print("Zip: ");
String zip = scanner.nextLine();
System.out.print("Phone: ");
String phone = scanner.nextLine();
System.out.print("Email: ");
String email = scanner.nextLine();


Contact c = new Contact(fn, ln, addr, city, state, zip, phone, email);
boolean added = service.addContact("Default", c);


System.out.println(added ? "Contact Added" : "Duplicate Contact Not Allowed");
}


private static void deleteContact() {
System.out.print("Enter First Name to Delete: ");
String name = scanner.nextLine();
boolean deleted = service.deleteContact("Default", name);
System.out.println(deleted ? "Deleted" : "Not Found");
}


private static void search() {
System.out.print("Enter City or State: ");
String val = scanner.nextLine();
service.searchPerson(val).forEach(System.out::println);
}


private static void count() {
System.out.print("Enter City or State: ");
String val = scanner.nextLine();
System.out.println("Count = " + service.countPerson(val));
    }
}