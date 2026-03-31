import java.util.*;

public class DisasterReliefApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReliefCenter center = new ReliefCenter("RC101");

        // Add stock
        center.addResource("Food", 100);
        center.addResource("Water", 200);
        center.addResource("MedicalKit", 50);

        Queue<AreaRequest> requestQueue = new LinkedList<>();

        System.out.println("Enter number of area requests:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter area name:");
            String areaName = sc.nextLine();

            Map<String, Integer> requestItems = new HashMap<>();

            System.out.println("Enter food required:");
            requestItems.put("Food", sc.nextInt());

            System.out.println("Enter water required:");
            requestItems.put("Water", sc.nextInt());

            System.out.println("Enter medical kits required:");
            requestItems.put("MedicalKit", sc.nextInt());
            sc.nextLine();

            requestQueue.add(new AreaRequest(areaName, requestItems));
        }

        // FIFO Allocation
        while (!requestQueue.isEmpty()) {

            AreaRequest request = requestQueue.poll();

            try {
                center.allocateResources(request);
                System.out.println("Allocated successfully to: " + request.getAreaName());
            } catch (InsufficientResourceException e) {
                System.out.println("Allocation failed: " + e.getMessage());
            }
        }

        // Final Report
        System.out.println("Final Stock Report:");
        System.out.println(center.getStock());

        sc.close();
    }
}
