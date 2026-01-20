import java.util.List;


public class AddressBookService {


private AddressBookDAO dao = new AddressBookDAO();


public void createAddressBook(String name) {
dao.addAddressBook(name);
}


public boolean addContact(String bookName, Contact contact) {
return dao.addContact(bookName, contact);
}


public boolean deleteContact(String bookName, String firstName) {
return dao.deleteContact(bookName, firstName);
}


public List<Contact> searchPerson(String value) {
return dao.searchByCityOrState(value);
}


public long countPerson(String value) {
return dao.countByCityOrState(value);
  }
}