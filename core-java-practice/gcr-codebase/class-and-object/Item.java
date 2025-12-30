class Item {

    //item attributes
    String itemCode;
    String itemName;
    double price;

    // method for item details
    void displayItemDetails() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    //main method 
    public static void main(String[] args) {

        // Creating first item
        Item item1 = new Item();
        item1.itemCode = "01AA";
        item1.price = 500.0;
        item1.itemName = "Water bottle";

        // Creating second item
        Item item2 = new Item();
        item2.itemCode = "01BB";
        item2.price = 700.0;
        item2.itemName = "Rice";

        // Creating third item
        Item item3 = new Item();
        item3.itemCode = "02AA";
        item3.price = 400.0;
        item3.itemName = "blackboard";

        // Displaying item details
        item1.displayItemDetails();
        item2.displayItemDetails();
        item3.displayItemDetails();
    }
}
