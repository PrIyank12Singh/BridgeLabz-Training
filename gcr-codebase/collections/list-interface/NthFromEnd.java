import java.util.*;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) return null; // N larger than list size
            fast.next();
        }

        // Move both until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));

        String result = findNthFromEnd(list, 2);

        System.out.println(result);
    }
}
