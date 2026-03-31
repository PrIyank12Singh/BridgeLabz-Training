import java.util.HashMap;
import java.util.Map;

public class ReliefCenter {

    private String centerId;
    private HashMap<String, Integer> stock;

    public ReliefCenter(String centerId) {
        this.centerId = centerId;
        this.stock = new HashMap<>();
    }

    public void addResource(String item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
    }

    public void allocateResources(AreaRequest request) throws InsufficientResourceException {

        for (Map.Entry<String, Integer> entry : request.getRequestedItems().entrySet()) {

            String item = entry.getKey();
            int requiredQty = entry.getValue();

            int availableQty = stock.getOrDefault(item, 0);

            if (availableQty < requiredQty) {
                throw new InsufficientResourceException(
                        "Not enough " + item + " for area " + request.getAreaName());
            }
        }

        // Deduct after checking all
        for (Map.Entry<String, Integer> entry : request.getRequestedItems().entrySet()) {
            String item = entry.getKey();
            int requiredQty = entry.getValue();
            stock.put(item, stock.get(item) - requiredQty);
        }
    }

    public HashMap<String, Integer> getStock() {
        return stock;
    }
}
