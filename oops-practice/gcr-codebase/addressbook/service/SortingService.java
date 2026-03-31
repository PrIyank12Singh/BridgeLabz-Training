package service;

import model.ContactPerson;

import java.util.Comparator;
import java.util.List;

public class SortingService {

    public void sortByFirstName(List<ContactPerson> contacts) {
        contacts.sort(Comparator.comparing(ContactPerson::getFirstName));
    }

    public void sortByCity(List<ContactPerson> contacts) {
        contacts.sort(Comparator.comparing(c -> c.getCity().toLowerCase()));
    }

    public void sortByState(List<ContactPerson> contacts) {
        contacts.sort(Comparator.comparing(c -> c.getState().toLowerCase()));
    }

    public void sortByZip(List<ContactPerson> contacts) {
        contacts.sort(Comparator.comparing(ContactPerson::getZip));
    }
}
