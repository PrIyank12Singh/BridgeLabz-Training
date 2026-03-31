import java.util.*;

public class ReverseList {

    // Reverse ArrayList
    public static void reverseArrayList(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }

    // Reverse LinkedList
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int x : list) {
            result.addFirst(x);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseArrayList(arr);
        System.out.println(arr);

        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        ll = reverseLinkedList(ll);
        System.out.println(ll);
    }
}
