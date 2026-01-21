import java.util.*;

public class Frequency {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println(countFrequency(input));
    }
}
