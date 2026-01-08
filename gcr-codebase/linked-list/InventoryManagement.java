import java.util.Scanner;

class ItemNode {
    int id, quantity;
    String name;
    double price;
    ItemNode next;

    ItemNode(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    private ItemNode head;

    // Add at end
    void addItem(ItemNode node) {
        if (head == null) {
            head = node;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    // remove by ID
    void removeItem(int id) {
        if (head == null) return;

        if (head.id == id) {
            head = head.next;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.id != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // Update quantity
    void updateQuantity(int id, int qty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = qty;
                return;
            }
            temp = temp.next;
        }
    }

    // Search
    void search(String key) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.name.equals(key) || String.valueOf(temp.id).equals(key))
                print(temp);
            temp = temp.next;
        }
    }

    // Total value
    void totalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value = " + total);
    }

    // Sort by ascending order
    void sortByPrice() {
        for (ItemNode i = head; i != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if (i.price > j.price) {
                    swap(i, j);
                }
            }
        }
    }

    void swap(ItemNode a, ItemNode b) {
        int id = a.id, qty = a.quantity;
        String name = a.name;
        double price = a.price;

        a.id = b.id; a.quantity = b.quantity; a.name = b.name; a.price = b.price;
        b.id = id; b.quantity = qty; b.name = name; b.price = price;
    }

    void display() {
        ItemNode temp = head;
        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
    }

    void print(ItemNode i) {
        System.out.println(i.id + " | " + i.name + " | " + i.quantity + " | " + i.price);
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList list = new InventoryList();

        while (true) {
            System.out.println("\n1.Add 2.Remove 3.Update Qty 4.Search 5.Total 6.Sort 7.Display 8.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    list.addItem(new ItemNode(
                        sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble()));
                    break;
                case 2:
                    list.removeItem(sc.nextInt());
                    break;
                case 3:
                    list.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    list.search(sc.next());
                    break;
                case 5:
                    list.totalValue();
                    break;
                case 6:
                    list.sortByPrice();
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    sc.close(); 
                    return;
            }
        }
    }
}
