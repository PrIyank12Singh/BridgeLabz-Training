import java.util.*;

public class EventWelcomeApp {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Rahul", "Priya", "Amit"
        );

        attendees.forEach(name ->
                System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
