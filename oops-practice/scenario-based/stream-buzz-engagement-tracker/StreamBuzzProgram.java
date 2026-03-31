import java.util.*;

public class StreamBuzzProgram {

    // Register a creator
    public void registerCreator(StreamBuzzCreatorStats record) {
        StreamBuzzCreatorStats.engagementBoard.add(record);
        System.out.println("Creator registered successfully\n");
    }

    // Get weekly counts where likes >= threshold
    public Map<String, Integer> getTopPostCounts(List<StreamBuzzCreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (StreamBuzzCreatorStats creator : records) {
            int count = 0;
            for (double like : creator.weeklyLikes) {
                if (like >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.creatorName, count);
            }
        }

        return result;
    }

    // Calculate overall average weekly likes
    public double calculateAverageLikes() {
        if (StreamBuzzCreatorStats.engagementBoard.isEmpty()) {
            return 0;
        }

        double totalLikes = 0;
        int totalWeeks = 0;

        for (StreamBuzzCreatorStats creator : StreamBuzzCreatorStats.engagementBoard) {
            for (double like : creator.weeklyLikes) {
                totalLikes += like;
                totalWeeks++;
            }
        }

        return totalLikes / totalWeeks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzzProgram program = new StreamBuzzProgram();

        while (true) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        while (true) {
                            try {
                                likes[i] = Double.parseDouble(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid number:");
                            }
                        }
                    }

                    StreamBuzzCreatorStats record = new StreamBuzzCreatorStats(name, likes);
                    program.registerCreator(record);
                    break;

                case "2":
                    System.out.print("Enter like threshold: ");
                    double threshold;
                    while (true) {
                        try {
                            threshold = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number:");
                        }
                    }

                    Map<String, Integer> topPosts = program.getTopPostCounts(StreamBuzzCreatorStats.engagementBoard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week\n");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                        System.out.println();
                    }
                    break;

                case "3":
                    double average = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int) average + "\n");
                    break;

                case "4":
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return;

                default:
                    System.out.println("Invalid choice, please try again\n");
                    break;
            }
        }
    }
}
