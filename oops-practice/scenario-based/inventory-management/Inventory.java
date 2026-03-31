public class Inventory {

    private Product[] products;
    private int count;
    private AlertService alertService;

    public Inventory(AlertService alertService) {
        this.products = new Product[10];
        this.count = 0;
        this.alertService = alertService;
    }

    public void addProduct(Product product) {
        products[count++] = product;
        System.out.println("Product added: " + product.getName());
    }

    public void updateStock(int productId, int newStock) throws OutOfStockException {
        Product product = findProduct(productId);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        if (newStock < 0) {
            throw new OutOfStockException("Stock cannot be negative");
        }

        product.setStock(newStock);
        System.out.println("Stock updated for " + product.getName());

        if (newStock <= 2) {
            alertService.sendLowStockAlert(product);
        }
    }

    private Product findProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }
}
