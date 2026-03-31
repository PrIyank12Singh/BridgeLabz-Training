import java.util.*;

class StackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q1.add(x);
    }

    // Pop element from stack
    public int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");

        // Move all except last to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // Peek top element
    public int top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int top = q1.remove();
        q2.add(top);

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class MainStackQueue {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // 3
        System.out.println(stack.top()); // 2
    }
}
