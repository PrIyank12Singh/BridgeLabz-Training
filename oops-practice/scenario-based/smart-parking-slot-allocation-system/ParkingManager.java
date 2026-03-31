import java.util.*;

public class ParkingManager {

    private Map<Integer, ParkingSlot> slots = new HashMap<>();
    private Queue<Vehicle> waitingQueue = new LinkedList<>();

    public ParkingManager(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            slots.put(i, new ParkingSlot(i));
        }
    }

    public void parkVehicle(Vehicle vehicle) throws NoParkingSlotAvailableException {

        for (ParkingSlot slot : slots.values()) {
            if (!slot.isOccupied()) {
                slot.assignVehicle(vehicle);
                System.out.println(vehicle.getType() + " parked at slot " + slot.getSlotNumber());
                return;
            }
        }

        // If no slot available
        waitingQueue.add(vehicle);
        throw new NoParkingSlotAvailableException("No slot available. Vehicle added to waiting queue.");
    }

    public void releaseSlot(int slotNumber) {

        ParkingSlot slot = slots.get(slotNumber);

        if (slot != null && slot.isOccupied()) {
            slot.removeVehicle();
            System.out.println("Slot " + slotNumber + " is now free.");

            // Allocate next vehicle from queue
            if (!waitingQueue.isEmpty()) {
                Vehicle nextVehicle = waitingQueue.poll();
                slot.assignVehicle(nextVehicle);
                System.out.println("Waiting vehicle " + nextVehicle.getVehicleNumber() + 
                                   " allocated to slot " + slotNumber);
            }
        }
    }

    public void displayStatus() {
        for (ParkingSlot slot : slots.values()) {
            System.out.println("Slot " + slot.getSlotNumber() + 
                " -> " + (slot.isOccupied() ? "Occupied" : "Free"));
        }

        System.out.println("Waiting Queue Size: " + waitingQueue.size());
    }
}
