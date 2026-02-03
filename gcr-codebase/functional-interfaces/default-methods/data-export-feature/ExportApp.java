public class ExportApp {

    public static void main(String[] args) {
        Exporter report = new ReportGenerator();

        report.exportCSV("Sales Data");
        report.exportPDF("Sales Data");
        report.exportToJSON("Sales Data");
    }
}
