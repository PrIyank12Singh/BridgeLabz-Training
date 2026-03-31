

import java.util.*;

public class EduResultsApp {

    public static void main(String[] args) {

        // District-wise sorted student lists
        List<Student> district1 = Arrays.asList(
                new Student("Alice", "D1", 95),
                new Student("Bob", "D1", 90),
                new Student("Charlie", "D1", 85)
        );

        List<Student> district2 = Arrays.asList(
                new Student("David", "D2", 92),
                new Student("Eve", "D2", 90),
                new Student("Frank", "D2", 80)
        );

        List<Student> district3 = Arrays.asList(
                new Student("Grace", "D3", 96),
                new Student("Heidi", "D3", 88),
                new Student("Ivan", "D3", 85)
        );

        List<List<Student>> allDistricts = Arrays.asList(district1, district2, district3);

        // Merge all districts into final rank list
        List<Student> finalRankList = RankSheetGenerator.mergeDistricts(allDistricts);

        System.out.println("----- Final State-wise Rank List -----");
        int rank = 1;
        for (Student s : finalRankList) {
            System.out.println(rank++ + ". " + s);
        }
    }
}

