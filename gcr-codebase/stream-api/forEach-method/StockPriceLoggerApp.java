import java.util.*;

public class StockPriceLoggerApp {
    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(
                102.5, 103.8, 101.2, 104.6, 105.0
        );

        // Terminal operation
        stockPrices.forEach(price ->
                System.out.println("Live Price Update: " + price)
        );
    }
}
