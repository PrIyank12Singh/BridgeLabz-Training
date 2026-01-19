import addressbook.model.*;
import java.util.*;


public class AddressBookDAO {


  private Map<String, AddressBook> addressBooks = new HashMap<>();


  public void addAddressBook(String name) {
  addressBooks.putIfAbsent(name, new AddressBook(name));
  }


  public AddressBook getAddressBook(String name) {
  return addressBooks.get(name);
  }


  public boolean addContact(String bookName, Contact contact) {
  AddressBook book = addressBooks.get(bookName);
  if (book.getContacts().contains(contact)) {
  return false;
  }
  book.getContacts().add(contact);
  return true;
  }


  public boolean deleteContact(String bookName, String firstName) {
  AddressBook book = addressBooks.get(bookName);
  return book.getContacts().removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
  }


  public List<Contact> searchByCityOrState(String value) {
  List<Contact> result = new ArrayList<>();
  for (AddressBook book : addressBooks.values()) {
  for (Contact c : book.getContacts()) {
  if (c.getCity().equalsIgnoreCase(value) || c.getState().equalsIgnoreCase(value)) {
  result.add(c);
  }
  }
  }
  return result;
  }


  public long countByCityOrState(String value) {
  return searchByCityOrState(value).size();
  }
}