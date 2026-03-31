class VehicleQueue {
    private int[] queue;
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public VehicleQueue(int capacity) {
        queue = new int[capacity];
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int id) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot add vehicle " + id);
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = id;
        size++;

        System.out.println("Vehicle " + id + " added to waiting queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return -1;
        }

        int id = queue[front];
        front = (front + 1) % queue.length;
        size--;

        return id;
    }
}
