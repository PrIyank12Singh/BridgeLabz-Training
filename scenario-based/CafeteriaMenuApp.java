import java.util.Scanner;

class MenuItem {
    private String name;

    
    public MenuItem(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }
}

// Class representing the Cafeteria Menu
class CafeteriaMenu {
    private MenuItem[] items;

    // Constructor
    public CafeteriaMenu(MenuItem[] items) {
        this.items = items;
    }

    // Display all menu items
    public void displayMenu() {
        System.out.println(" Cafeteria Menu ");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " : " + items[i].getName());
        }
    }

    // get a menu item by index
    public MenuItem getItemByIndex(int index) {
        if (index >= 0 && index < items.length) {
            return items[index];
        } else {
            return null; // invalid selection
        }
    }
}

// Main Application
public class CafeteriaMenuApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MenuItem[] items = {
            new MenuItem("Veg Sandwich"),
            new MenuItem("Cheese Burger"),
            new MenuItem("Pasta"),
            new MenuItem("Fried Rice"),
            new MenuItem("Pizza Slice"),
            new MenuItem("Samosa"),
            new MenuItem("Coffee"),
            new MenuItem("Tea"),
            new MenuItem("Cold Drink"),
            new MenuItem("Ice Cream")
        };

        // create cafeteria menu object
        CafeteriaMenu menu = new CafeteriaMenu(items);

        // display menu
        menu.displayMenu();

        //user input
        System.out.print("\nEnter item index to order: ");
        int choice = sc.nextInt();

        // Get selected item
        MenuItem selectedItem = menu.getItemByIndex(choice);

        if (selectedItem != null) {
            System.out.println("\nYou selected: " + selectedItem.getName());
        } else {
            System.out.println("\nInvalid selection!");
        }

        sc.close();
    }
}
