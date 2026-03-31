import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartWaterMonitoringApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<WaterTank> tankList = new ArrayList<>();
        WaterTankService service = new WaterTankService();

        System.out.println("Enter number of tanks:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter Tank ID:");
            String id = sc.next();

            System.out.println("Enter Capacity:");
            double capacity = sc.nextDouble();

            System.out.println("Enter Current Level:");
            double level = sc.nextDouble();

            try {
                WaterTank tank = new WaterTank(id, capacity, level);
                tankList.add(tank);
            } catch (InvalidWaterLevelException e) {
                System.out.println(e.getMessage());
            }
        }

        // Check Alerts
        service.checkAlerts(tankList);

        // Sort Tanks
        service.sortByLowestLevel(tankList);

        System.out.println("\nTanks sorted by lowest water level:");

        for (WaterTank tank : tankList) {
            System.out.println("Tank ID: " + tank.getTankId()
                    + ", Current Level: " + tank.getCurrentLevel()
                    + ", Usage %: " + tank.getUsagePercentage());
        }

        sc.close();
    }
}
