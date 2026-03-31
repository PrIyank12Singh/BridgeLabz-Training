import java.util.*;

public class ChargingStationManager {

    private Map<Integer, ChargingSlotUnit> slots = new HashMap<>();
    private Queue<VehicleUnit> waitingQueue = new LinkedList<>();
    private PricingStrategy pricingStrategy;

    public ChargingStationManager(int totalSlots, PricingStrategy pricingStrategy) {

        this.pricingStrategy = pricingStrategy;

        for (int i = 1; i <= totalSlots; i++) {
            slots.put(i, new ChargingSlotUnit(i));
        }
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void assignSlot(VehicleUnit vehicle)
            throws NoChargingSlotAvailableException {

        for (ChargingSlotUnit slot : slots.values()) {
            if (!slot.isOccupied()) {
                slot.occupySlot();
                double bill = pricingStrategy.calculatePrice(vehicle.getUnitsConsumed());

                System.out.println("Vehicle " + vehicle.getVehicleNumber()
                        + " assigned to Slot " + slot.getSlotId());
                System.out.println("Bill Amount: " + bill);
                return;
            }
        }

        waitingQueue.offer(vehicle);
        throw new NoChargingSlotAvailableException(
                "No slots available. Vehicle added to waiting queue.");
    }

    public void showWaitingQueue() {
        System.out.println("Waiting Vehicles:");
        for (VehicleUnit v : waitingQueue) {
            System.out.println(v.getVehicleNumber());
        }
    }
}
