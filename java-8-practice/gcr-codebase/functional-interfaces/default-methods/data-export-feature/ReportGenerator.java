public class ReportGenerator implements Exporter {

    @Override
    public void exportCSV(String data) {
        System.out.println("Exporting to CSV: " + data);
    }

    @Override
    public void exportPDF(String data) {
        System.out.println("Exporting to PDF: " + data);
    }

    // No need to implement exportToJSON() unless custom behavior is needed
}
