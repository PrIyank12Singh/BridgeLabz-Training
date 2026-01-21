

import java.util.*;

public class RankSheetGenerator {

    // Merge two sorted lists of students
    private static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            // For descending order by score (higher score first)
            if (left.get(i).score > right.get(j).score) {
                merged.add(left.get(i++));
            } else {
                // Equal scores: take from left first (stability)
                merged.add(right.get(j++));
            }
        }

        // Add remaining elements
        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));
        return merged;
    }

    // Merge sort
    public static List<Student> mergeSort(List<Student> students) {
        if (students.size() <= 1) return students;

        int mid = students.size() / 2;
        List<Student> left = mergeSort(new ArrayList<>(students.subList(0, mid)));
        List<Student> right = mergeSort(new ArrayList<>(students.subList(mid, students.size())));

        return merge(left, right);
    }

    // Merge multiple district lists
    public static List<Student> mergeDistricts(List<List<Student>> districtLists) {
        List<Student> merged = new ArrayList<>();
        for (List<Student> district : districtLists) {
            merged = merge(merged, district);
        }
        return merged;
    }
}

