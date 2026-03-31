public class CsvEmployeeContactRecord {

    private int id;
    private String name;
    private String email;
    private String phone;

    public CsvEmployeeContactRecord(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public boolean isEmailValid() {
        // Basic regex for email validation
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public boolean isPhoneValid() {
        // Exactly 10 digits
        return phone.matches("\\d{10}");
    }

    public void printInvalidRecord() {
        System.out.println("Invalid Record Found:");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email + (isEmailValid() ? "" : " <- Invalid"));
        System.out.println("Phone : " + phone + (isPhoneValid() ? "" : " <- Invalid"));
        System.out.println("----------------------");
    }
}
