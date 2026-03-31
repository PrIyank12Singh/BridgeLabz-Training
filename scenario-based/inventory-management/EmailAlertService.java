public class EmailAlertService implements AlertService {

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("Low stock alert for product: " 
            + product.getName() + " | Stock: " + product.getStock());
    }
}
