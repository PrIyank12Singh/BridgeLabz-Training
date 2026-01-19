import java.util.Objects;


public class Contact {
private String firstName;
private String lastName;
String address;
private String city;
private String state;
String zip;
private String phone;
String email;


public Contact(String firstName, String lastName, String address, String city,
String state, String zip, String phone, String email) {
this.firstName = firstName;
this.lastName = lastName;
this.address = address;
this.city = city;
this.state = state;
this.zip = zip;
this.phone = phone;
this.email = email;
}


public String getFirstName() { return firstName; }
public String getLastName() { return lastName; }


public String getCity() { return city; }


public String getState() { return state; }


@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Contact contact = (Contact) o;
return firstName.equalsIgnoreCase(contact.firstName)
&& lastName.equalsIgnoreCase(contact.lastName);
}


@Override
public int hashCode() {
return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
}


@Override
public String toString() {
return firstName + " " + lastName + ", " + city + ", " + state + ", " + phone;
}
}
