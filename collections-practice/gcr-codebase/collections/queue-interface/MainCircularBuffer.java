class CircularBuffer {
    private int[] buffer;
    private int capacity;
    private int start = 0;
    private int end = 0;
    private int size = 0;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Add element
    public void insert(int val) {
        buffer[end] = val;
        end = (end + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            start = (start + 1) % capacity; // overwrite oldest
        }
    }

    // Display buffer
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            int index = (start + i) % capacity;
            System.out.print(buffer[index]);
            if (i != size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class MainCircularBuffer {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // [1, 2, 3]

        cb.insert(4);
        cb.display(); // [2, 3, 4]
    }
}
