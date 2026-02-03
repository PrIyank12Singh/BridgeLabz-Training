public interface Exporter {

    void exportCSV(String data);
    void exportPDF(String data);

    // Default method added for JSON export
    default void exportToJSON(String data) {
        System.out.println("Exporting to JSON: " + data);
    }
}
