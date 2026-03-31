import java.util.*;
import java.util.stream.Collectors;

class Doctor {
    private String name;
    private String specialty;
    private boolean weekendAvailable;

    public Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailable = weekendAvailable;
    }

    public String getSpecialty() { return specialty; }
    public boolean isWeekendAvailable() { return weekendAvailable; }

    @Override
    public String toString() {
        return name + " - " + specialty;
    }
}

public class DoctorAvailabilityApp {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr A", "Cardiology", true),
                new Doctor("Dr B", "Neurology", false),
                new Doctor("Dr C", "Orthopedics", true)
        );

        List<Doctor> available = doctors.stream()
                .filter(Doctor::isWeekendAvailable) // Stateless
                .sorted(Comparator.comparing(Doctor::getSpecialty)) // Stateful
                .collect(Collectors.toList()); // Terminal

        available.forEach(System.out::println);
    }
}
