import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeNameUppercaseApp {

    public static void main(String[] args) {

        List<String> employees = Arrays.asList(
                "Ravi",
                "Asha",
                "Kiran",
                "Meera"
        );

        List<String> upperCaseNames = employees.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        upperCaseNames.forEach(System.out::println);
    }
}
