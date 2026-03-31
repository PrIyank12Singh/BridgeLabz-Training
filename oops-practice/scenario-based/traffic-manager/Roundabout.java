class Roundabout {
    private VehicleNode head = null;

    public void addVehicle(int id) {
        VehicleNode newNode = new VehicleNode(id);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            VehicleNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }

        System.out.println("Vehicle " + id + " entered roundabout.");
    }

    public void removeVehicle() {
        if (head == null) {
            System.out.println("Roundabout is empty. No vehicle to remove.");
            return;
        }

        if (head.next == head) {
            System.out.println("Vehicle " + head.vehicleId + " exited roundabout.");
            head = null;
            return;
        }

        VehicleNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        System.out.println("Vehicle " + head.vehicleId + " exited roundabout.");
        temp.next = head.next;
        head = head.next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        System.out.print("Roundabout Vehicles: ");

        VehicleNode temp = head;
        do {
            System.out.print(temp.vehicleId + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to start)");
    }
}
