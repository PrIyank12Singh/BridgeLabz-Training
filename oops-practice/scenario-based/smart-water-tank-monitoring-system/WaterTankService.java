import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WaterTankService {

    public void checkAlerts(List<WaterTank> tanks) {

        for (WaterTank tank : tanks) {
            if (tank.isBelowThreshold()) {
                System.out.println("ALERT: Tank " + tank.getTankId()
                        + " is below 20% level.");
            }
        }
    }

    public void sortByLowestLevel(List<WaterTank> tanks) {

        Collections.sort(tanks,
                Comparator.comparingDouble(WaterTank::getCurrentLevel));
    }
}
