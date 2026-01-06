import java.util.*;

public class CafeteriaMenuApp {

    static String[] menuItems = {
        "Idli", "Dosa", "Vada", "Poha", "Sandwich",
        "Burger", "Pizza", "Pasta", "Tea", "Lemonade"
    };

    // Method to display menu
    public static void displayMenu() {
        System.out.println("Cafeteria Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " - " + menuItems[i]);
        }
    }

    // Method to get item by index
    public static String getItemByIndex(int index) {
        if (index >= 0 && index < menuItems.length) {
            return menuItems[index];
        }
        return "Invalid selection";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Calling method menu
        displayMenu();
        int choice = sc.nextInt();

        String selectedItem = getItemByIndex(choice);
        System.out.println("You selected: " + selectedItem);

        sc.close();
    }
}
