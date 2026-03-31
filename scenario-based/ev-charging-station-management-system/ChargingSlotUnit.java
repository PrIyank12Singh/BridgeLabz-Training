public class ChargingSlotUnit {

    private int slotId;
    private boolean isOccupied;

    public ChargingSlotUnit(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupySlot() {
        isOccupied = true;
    }

    public void freeSlot() {
        isOccupied = false;
    }
}
