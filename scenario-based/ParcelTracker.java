public class ParcelTracker {

    // Node
    static class StageNode {
        String stageName;
        StageNode next;

        StageNode(String stageName) {
            this.stageName = stageName;
            this.next = null;
        }
    }

    // Linked List
    static class DeliveryChain {

        private StageNode head;

        // Add stage at end
        public void addStage(String stageName) {
            StageNode newNode = new StageNode(stageName);

            if (head == null) {
                head = newNode;
                return;
            }

            StageNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Add checkpoint after a given stage
        public void addCheckpointAfter(String existingStage, String newStage) {
            StageNode temp = head;

            while (temp != null && !temp.stageName.equals(existingStage)) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Stage not found: " + existingStage);
                return;
            }

            StageNode newNode = new StageNode(newStage);
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Forward tracking
        public void trackParcel() {
            if (head == null) {
                System.out.println("Parcel data missing (no stages).");
                return;
            }

            StageNode temp = head;
            System.out.print("Parcel Tracking: ");

            while (temp != null) {
                System.out.print(temp.stageName);

                if (temp.next != null)
                    System.out.print(" -> ");

                temp = temp.next;
            }

            System.out.println();
        }

        // Simulate parcel lost (null pointer case)
        public void markLostAfter(String stageName) {
            StageNode temp = head;

            while (temp != null && !temp.stageName.equals(stageName)) {
                temp = temp.next;
            }

            if (temp != null) {
                temp.next = null;
                System.out.println("Parcel lost after stage: " + stageName);
            }
        }
    }

    // Main
    public static void main(String[] args) {

        DeliveryChain chain = new DeliveryChain();

        // Initial stages
        chain.addStage("Packed");
        chain.addStage("Shipped");
        chain.addStage("In Transit");
        chain.addStage("Delivered");

        chain.trackParcel();

        // Add intermediate checkpoint
        chain.addCheckpointAfter("Shipped", "Customs Check");
        chain.trackParcel();

        // Simulate parcel lost
        chain.markLostAfter("Customs Check");
        chain.trackParcel();
    }
}
