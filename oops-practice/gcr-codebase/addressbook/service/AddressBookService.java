package service;

import dao.DatabaseRepository;
import dao.JsonServerRepository;
import dao.RepositoryFactory;
import model.AddressBookDirectory;
import model.ContactPerson;
import util.JsonUtil;
import util.ThreadManager;

import java.util.*;
import java.util.List;

public class AddressBookService {

    private Map<String, AddressBookDirectory> addressBookMap;
    private AddressBookDirectory currentDirectory;
    private Map<String, List<ContactPerson>> cityDictionary;
    private Map<String, List<ContactPerson>> stateDictionary;
    private Scanner scanner;

    // Repositories using RepositoryFactory (UC16 & UC18)
    private DatabaseRepository dbRepo;
    private JsonServerRepository jsonServerRepo;

    public AddressBookService() {
        this.addressBookMap = new HashMap<>();
        this.cityDictionary = new HashMap<>();
        this.stateDictionary = new HashMap<>();
        this.scanner = new Scanner(System.in);

        // Initialize repositories via Factory (OCP compliant)
        this.dbRepo = (DatabaseRepository) RepositoryFactory.getRepository("database");
        this.jsonServerRepo = (JsonServerRepository) RepositoryFactory.getRepository("jsonserver");
    }

    // ==============================
    // UC1–UC5: Address Book Management
    // ==============================
    public void createAddressBook() {
        System.out.println("Enter New Address Book Name:");
        String name = scanner.nextLine();

        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book already exists!");
            return;
        }

        AddressBookDirectory directory = new AddressBookDirectory();
        addressBookMap.put(name, directory);
        currentDirectory = directory;

        System.out.println("Address Book Created Successfully!");
    }

    public void selectAddressBook() {
        System.out.println("Enter Address Book Name:");
        String name = scanner.nextLine();

        if (addressBookMap.containsKey(name)) {
            currentDirectory = addressBookMap.get(name);
            System.out.println("Address Book Selected!");
        } else {
            System.out.println("Address Book Not Found!");
        }
    }

    // ==============================
    // UC1, UC6: Add Contact + Duplicate Check
    // ==============================
    public void addContactUsingConsole() {

        if (currentDirectory == null) {
            System.out.println("Please create/select Address Book first!");
            return;
        }

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        ContactPerson contact = new ContactPerson(
                firstName, lastName, address, city, state, zip, phone, email
        );

        boolean added = currentDirectory.addContact(contact);

        if (added) {
            addToCityDictionary(contact);
            addToStateDictionary(contact);
            System.out.println("Contact Added Successfully!");
        } else {
            System.out.println("Duplicate Contact Not Allowed!");
        }
    }

    // ==============================
    // Display Contacts
    // ==============================
    public void displayContacts() {

        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }

        if (currentDirectory.getContactList().isEmpty()) {
            System.out.println("Address Book Empty!");
            return;
        }

        currentDirectory.getContactList().forEach(System.out::println);
    }

    // ==============================
    // UC11–UC14: Sorting
    // ==============================
    public void sortByName() {
        sortContacts(Comparator.comparing(ContactPerson::getFirstName)
                .thenComparing(ContactPerson::getLastName), "Name");
    }

    public void sortByCity() {
        sortContacts(Comparator.comparing(ContactPerson::getCity)
                .thenComparing(ContactPerson::getFirstName), "City");
    }

    public void sortByState() {
        sortContacts(Comparator.comparing(ContactPerson::getState)
                .thenComparing(ContactPerson::getFirstName), "State");
    }

    public void sortByZip() {
        sortContacts(Comparator.comparing(ContactPerson::getZip)
                .thenComparing(ContactPerson::getFirstName), "Zip");
    }

    private void sortContacts(Comparator<ContactPerson> comparator, String field) {

        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }

        List<ContactPerson> contacts = currentDirectory.getContactList();

        if (contacts.isEmpty()) {
            System.out.println("Address Book Empty!");
            return;
        }

        contacts.sort(comparator);
        System.out.println("Sorted By " + field + ":");
        contacts.forEach(System.out::println);
    }

    // ==============================
    // UC15: JSON Read/Write
    // ==============================
    public void saveContactsToJson() {
        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }
        System.out.println("Enter JSON file path to save:");
        String path = scanner.nextLine();
        ThreadManager.run(() -> {
            JsonUtil.writeContactsToJson(path, currentDirectory.getContactList());
        });
    }

    public void loadContactsFromJson() {
        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }
        System.out.println("Enter JSON file path to load:");
        String path = scanner.nextLine();
        ThreadManager.run(() -> {
            List<ContactPerson> contacts = JsonUtil.readContactsFromJson(path);
            if (contacts != null) {
                for (ContactPerson c : contacts) {
                    currentDirectory.addContact(c);
                    addToCityDictionary(c);
                    addToStateDictionary(c);
                }
                System.out.println("Contacts loaded successfully!");
            }
        });
    }

    // ==============================
    // UC16: JSONServer Read/Write
    // ==============================
    public void saveContactsToJsonServer() {
        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }
        ThreadManager.run(() -> {
            jsonServerRepo.saveContacts(currentDirectory.getContactList());
        });
    }

    public void loadContactsFromJsonServer() {
        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }
        ThreadManager.run(() -> {
            List<ContactPerson> contacts = jsonServerRepo.loadContacts();
            for (ContactPerson c : contacts) {
                currentDirectory.addContact(c);
                addToCityDictionary(c);
                addToStateDictionary(c);
            }
            System.out.println("Contacts loaded from JSONServer successfully!");
        });
    }

    // ==============================
    // UC18: Database Save/Load
    // ==============================
    public void saveContactsToDatabase() {
        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }
        ThreadManager.run(() -> {
            dbRepo.saveContacts(currentDirectory.getContactList());
        });
    }

    public void loadContactsFromDatabase() {
        if (currentDirectory == null) {
            System.out.println("Select Address Book first!");
            return;
        }
        ThreadManager.run(() -> {
            List<ContactPerson> contacts = dbRepo.loadContacts();
            for (ContactPerson c : contacts) {
                currentDirectory.addContact(c);
                addToCityDictionary(c);
                addToStateDictionary(c);
            }
            System.out.println("Contacts loaded from Database successfully!");
        });
    }

    // ==============================
    // Dictionary Helpers (UC8–UC10)
    // ==============================
    private void addToCityDictionary(ContactPerson person) {
        cityDictionary
                .computeIfAbsent(person.getCity(), k -> new ArrayList<>())
                .add(person);
    }

    private void addToStateDictionary(ContactPerson person) {
        stateDictionary
                .computeIfAbsent(person.getState(), k -> new ArrayList<>())
                .add(person);
    }

    public void viewPersonsByCity() {
        System.out.println("Enter City:");
        String city = scanner.nextLine();
        List<ContactPerson> persons = cityDictionary.get(city);
        if (persons == null) {
            System.out.println("No persons found.");
            return;
        }
        persons.forEach(System.out::println);
    }

    public void viewPersonsByState() {
        System.out.println("Enter State:");
        String state = scanner.nextLine();
        List<ContactPerson> persons = stateDictionary.get(state);
        if (persons == null) {
            System.out.println("No persons found.");
            return;
        }
        persons.forEach(System.out::println);
    }

    public void countByCity() {
        System.out.println("Enter City:");
        String city = scanner.nextLine();
        List<ContactPerson> persons = cityDictionary.get(city);
        System.out.println("Count: " + (persons == null ? 0 : persons.size()));
    }

    public void countByState() {
        System.out.println("Enter State:");
        String state = scanner.nextLine();
        List<ContactPerson> persons = stateDictionary.get(state);
        System.out.println("Count: " + (persons == null ? 0 : persons.size()));
    }
}
