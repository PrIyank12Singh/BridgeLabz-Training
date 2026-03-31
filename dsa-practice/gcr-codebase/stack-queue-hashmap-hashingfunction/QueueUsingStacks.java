import java.util.*;

class QueueUsingStacks {
    private Deque<Integer> stackEnq = new ArrayDeque<>();
    private Deque<Integer> stackDeq = new ArrayDeque<>();

    // Enqueue 
    public void enqueue(int x) {
        stackEnq.push(x);
    }

    // Dequeue 
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stackDeq.isEmpty()) {
            transfer();
        }

        return stackDeq.pop();
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stackDeq.isEmpty()) {
            transfer();
        }

        return stackDeq.peek();
    }

    private void transfer() {
        while (!stackEnq.isEmpty()) {
            stackDeq.push(stackEnq.pop());
        }
    }

    public boolean isEmpty() {
        return stackEnq.isEmpty() && stackDeq.isEmpty();
    }
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek());    // 20
        System.out.println(q.dequeue()); // 20
        System.out.println(q.dequeue()); // 30
    }
}
