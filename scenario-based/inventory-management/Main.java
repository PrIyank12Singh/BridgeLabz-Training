public class Main {
    public static void main(String[] args) {

        AlertService alertService = new EmailAlertService();
        Inventory inventory = new Inventory(alertService);

        Product p1 = new Product(1, "Keyboard", 10);
        Product p2 = new Product(2, "Mouse", 5);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        try {
            inventory.updateStock(1, 2);
            inventory.updateStock(2, 0);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }
}
