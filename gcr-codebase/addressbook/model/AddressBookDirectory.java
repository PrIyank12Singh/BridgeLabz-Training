package model;

import java.util.ArrayList;
import java.util.List;

public class AddressBookDirectory {

    private List<ContactPerson> contactList;

    public AddressBookDirectory() {
        this.contactList = new ArrayList<>();
    }

    public boolean addContact(ContactPerson contact) {

        if (contactList.contains(contact)) {
            return false; // Duplicate found
        }

        contactList.add(contact);
        return true;
    }

    public List<ContactPerson> getContactList() {
        return contactList;
    }
}
