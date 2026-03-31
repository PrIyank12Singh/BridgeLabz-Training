import java.util.Scanner;

// Step 1: Create custom exception
class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }
}

// Step 2: RobotHazardAuditor class
class RobotHazardAuditor {

    public double CalculateHazardRisk(double armPrecision, int workerDensity, String machineryState) 
            throws RobotSafetyException {

        // Validate armPrecision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }

        // Validate workerDensity
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        // Validate machineryState and get risk factor
        double machineRiskFactor;
        switch (machineryState) {
            case "Worn":
                machineRiskFactor = 1.3;
                break;
            case "Faulty":
                machineRiskFactor = 2.0;
                break;
            case "Critical":
                machineRiskFactor = 3.0;
                break;
            default:
                throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        // Calculate hazard risk
        double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
        return hazardRisk;
    }
}

// Step 3: Program class with main method
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = sc.nextDouble();

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
            String machineryState = sc.nextLine();

            double hazardRisk = auditor.CalculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        } finally {
            sc.close();
        }
    }
}
