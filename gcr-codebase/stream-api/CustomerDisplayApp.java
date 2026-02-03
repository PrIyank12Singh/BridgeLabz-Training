import java.util.*;
import java.util.stream.Collectors;

public class CustomerDisplayApp {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("rahul", "amit", "priya", "anita");

        List<String> result = names.stream()
                .map(String::toUpperCase) // Stateless
                .sorted() // Stateful
                .collect(Collectors.toList()); // Terminal

        result.forEach(System.out::println);
    }
}
