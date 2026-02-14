package service;

import model.ContactPerson;

import java.util.List;
import java.util.Optional;

public class ContactService {

    public Optional<ContactPerson> findContactByName(
            List<ContactPerson> contacts,
            String firstName,
            String lastName) {

        return contacts.stream()
                .filter(c ->
                        c.getFirstName().equalsIgnoreCase(firstName)
                                && c.getLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }

    public boolean deleteContact(
            List<ContactPerson> contacts,
            String firstName,
            String lastName) {

        Optional<ContactPerson> contact =
                findContactByName(contacts, firstName, lastName);

        if (contact.isPresent()) {
            contacts.remove(contact.get());
            return true;
        }
        return false;
    }
}
