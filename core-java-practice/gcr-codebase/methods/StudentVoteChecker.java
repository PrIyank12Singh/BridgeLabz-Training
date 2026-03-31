import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {
      //checking age if student is eligible to vote
        if (age < 0)
            return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //taking age as a input
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = scan.nextInt();
            System.out.println(canStudentVote(ages[i]));
        }
        scan.close();
    }
}
