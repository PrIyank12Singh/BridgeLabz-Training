import java.util.LinkedList;
import java.util.Queue;

public class TrafficManager {

    // Vehicle Node
    static class VehicleNode {
        String vehicleNumber;
        VehicleNode next;

        VehicleNode(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            this.next = null;
        }
    }

    // Circular Linked List
    static class Roundabout {

        private VehicleNode head = null;
        private VehicleNode tail = null;

        // Add car to roundabout
        public void addCar(String vehicleNumber) {
            VehicleNode newNode = new VehicleNode(vehicleNumber);

            if (head == null) {
                head = tail = newNode;
                newNode.next = newNode; // circular link
            } else {
                newNode.next = head;
                tail.next = newNode;
                tail = newNode;
            }

            System.out.println("Car entered roundabout: " + vehicleNumber);
        }

        // Remove car from roundabout
        public void removeCar() {
            if (head == null) {
                System.out.println("Roundabout is empty. No car to remove.");
                return;
            }

            String removedCar = head.vehicleNumber;

            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            System.out.println("Car exited roundabout: " + removedCar);
        }

        // Print roundabout state
        public void printState() {
            if (head == null) {
                System.out.println("Roundabout is empty.");
                return;
            }

            System.out.print("Roundabout State: ");

            VehicleNode temp = head;
            do {
                System.out.print(temp.vehicleNumber + " -> ");
                temp = temp.next;
            } while (temp != head);

            System.out.println("(back to start)");
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    // Waiting Queue
    static class WaitingQueue {

        private Queue<String> queue = new LinkedList<>();
        private int capacity;

        public WaitingQueue(int capacity) {
            this.capacity = capacity;
        }

        // Enqueue vehicle
        public void enqueue(String vehicleNumber) {
            if (queue.size() == capacity) {
                System.out.println("Queue Overflow! Vehicle " + vehicleNumber + " cannot enter now.");
                return;
            }

            queue.offer(vehicleNumber);
            System.out.println("Vehicle added to waiting queue: " + vehicleNumber);
        }

        // Dequeue vehicle
        public String dequeue() {
            if (queue.isEmpty()) {
                System.out.println("Queue Underflow! No vehicles waiting.");
                return null;
            }

            return queue.poll();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    // Main System
    public static void main(String[] args) {

        Roundabout roundabout = new Roundabout();
        WaitingQueue waitingQueue = new WaitingQueue(3);

        // Vehicles arrive
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");
        waitingQueue.enqueue("CAR-104"); // overflow case

        // Move from queue to roundabout
        for (int i = 0; i < 3; i++) {
            String car = waitingQueue.dequeue();
            if (car != null) {
                roundabout.addCar(car);
            }
        }

        roundabout.printState();

        // Cars exit
        roundabout.removeCar();
        roundabout.printState();

        roundabout.removeCar();
        roundabout.printState();

        // Try removing more
        roundabout.removeCar();
        roundabout.removeCar(); // empty case

        // Queue underflow
        waitingQueue.dequeue();
    }
}
