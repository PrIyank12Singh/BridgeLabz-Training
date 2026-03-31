import java.util.*;
import java.util.stream.IntStream;

public class StreamBuzzCreatorStats {
    public String creatorName;
    public double[] weeklyLikes;

    public StreamBuzzCreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }

    public static List<StreamBuzzCreatorStats> engagementBoard = new ArrayList<>();
}
