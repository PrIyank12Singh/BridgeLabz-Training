package dao;

import model.ContactPerson;

import java.util.List;

public interface AddressBookDAO {

    void save(List<ContactPerson> contacts);

    List<ContactPerson> load();
}
