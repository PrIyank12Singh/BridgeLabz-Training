import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class InvoiceRecord {
    String transactionId;

    public InvoiceRecord(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice for Transaction ID: " + transactionId;
    }
}

public class InvoiceCreationApp {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001", "TXN1002", "TXN1003"
        );

        List<InvoiceRecord> invoices = transactionIds.stream()
                .map(InvoiceRecord::new)
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
