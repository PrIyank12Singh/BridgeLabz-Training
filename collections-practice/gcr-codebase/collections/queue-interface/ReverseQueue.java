import java.util.*;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) return;

        int x = queue.remove();
        reverseQueue(queue);
        queue.add(x);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        reverseQueue(q);

        System.out.println(q);
    }
}
