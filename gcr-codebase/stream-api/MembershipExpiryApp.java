import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class GymMember {
    private String name;
    private LocalDate expiryDate;

    public GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return name + " - " + expiryDate;
    }
}

public class MembershipExpiryApp {
    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
                new GymMember("Rahul", LocalDate.now().plusDays(10)),
                new GymMember("Amit", LocalDate.now().plusDays(40)),
                new GymMember("Priya", LocalDate.now().plusDays(25))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<GymMember> expiringSoon = members.stream()
                .filter(m -> m.getExpiryDate().isAfter(today)
                        && m.getExpiryDate().isBefore(next30Days))
                .collect(Collectors.toList());

        expiringSoon.forEach(System.out::println);
    }
}
