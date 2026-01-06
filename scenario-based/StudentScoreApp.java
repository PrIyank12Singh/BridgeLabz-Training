import java.util.Scanner;

// Custom Exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

// Class representing a Student
class Student {
    private int score;

    public Student(int score) throws InvalidScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidScoreException("Score must be between 0 and 100. Invalid score: " + score);
        }
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

// Class for analyzing student scores
class ScoreAnalyzer {
    private Student[] students;

    public ScoreAnalyzer(Student[] students) {
        this.students = students;
    }

    public double calculateAverage() {
        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return (double) sum / students.length;
    }

    public int findMax() {
        int max = students[0].getScore();
        for (Student s : students) {
            if (s.getScore() > max) max = s.getScore();
        }
        return max;
    }

    public int findMin() {
        int min = students[0].getScore();
        for (Student s : students) {
            if (s.getScore() < min) min = s.getScore();
        }
        return min;
    }
}

// Main Application
public class StudentScoreApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            int score = sc.nextInt();
            try {
                students[i] = new Student(score);
            } catch (InvalidScoreException e) {
                System.out.println(e.getMessage());
                i--; // retry this student
            }
        }

        ScoreAnalyzer analyzer = new ScoreAnalyzer(students);
        System.out.println("\nAverage Score: " + analyzer.calculateAverage());
        System.out.println("Highest Score: " + analyzer.findMax());
        System.out.println("Lowest Score: " + analyzer.findMin());

        sc.close();
    }
}
