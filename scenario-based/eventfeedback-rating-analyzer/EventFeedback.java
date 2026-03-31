

import java.util.*;

public class EventFeedback {
    private Map<String, List<Integer>> feedbackMap = new HashMap<>();

    public void addFeedback(String eventId, int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5.");
        }
        feedbackMap.computeIfAbsent(eventId, k -> new ArrayList<>()).add(rating);
    }

    public double getAverageRating(String eventId) {
        List<Integer> ratings = feedbackMap.getOrDefault(eventId, new ArrayList<>());
        if (ratings.isEmpty()) return 0.0;
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public String getTopRatedEvent() {
        return feedbackMap.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0)))
                .map(Map.Entry::getKey)
                .orElse("No Events");
    }

    public static void main(String[] args) {
        EventFeedback feedbackSystem = new EventFeedback();
        try {
            feedbackSystem.addFeedback("E001", 5);
            feedbackSystem.addFeedback("E001", 4);
            feedbackSystem.addFeedback("E002", 3);
            feedbackSystem.addFeedback("E002", 5);
            feedbackSystem.addFeedback("E003", 2);

            System.out.println("Average Rating of E001: " + feedbackSystem.getAverageRating("E001"));
            System.out.println("Average Rating of E002: " + feedbackSystem.getAverageRating("E002"));
            System.out.println("Top Rated Event: " + feedbackSystem.getTopRatedEvent());

        } catch (InvalidRatingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
