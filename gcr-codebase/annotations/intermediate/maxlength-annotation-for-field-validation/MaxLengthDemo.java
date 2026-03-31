public class MaxLengthDemo {

    public static void main(String[] args) {

        try {
            User user1 = new User("Priyank");  // Valid
            System.out.println("Username: " + user1.getUsername());

            User user2 = new User("VeryLongUsername"); // exceeds max length
            System.out.println("Username: " + user2.getUsername());

        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
