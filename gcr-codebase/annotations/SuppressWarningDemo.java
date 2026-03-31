import java.util.ArrayList;

public class SuppressWarningDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList(); // raw Type

        list.add("Java");
        list.add(10);
        list.add(3.14);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
