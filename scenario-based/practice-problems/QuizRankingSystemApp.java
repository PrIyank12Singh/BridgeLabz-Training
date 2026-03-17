import java.util.*;

class Student {

    String name;
    String dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizRankingSystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Student> list = new ArrayList<>();

        while (n-- > 0) {

            String line = sc.nextLine();
            String[] p = line.split(" ");

            if (p[0].equals("Record")) {

                Student s = new Student(
                        p[1],
                        p[2],
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4]),
                        Integer.parseInt(p[5])
                );

                list.add(s);
                System.out.println("Record Added: " + s.name);
            }

            else if (p[0].equals("Top")) {

                if (list.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                String key = p[1];

                if (key.equals("Q1") || key.equals("Q2") || key.equals("Q3")) {

                    int max = Integer.MIN_VALUE;

                    for (Student s : list) {
                        int val = key.equals("Q1") ? s.q1 :
                                  key.equals("Q2") ? s.q2 : s.q3;
                        max = Math.max(max, val);
                    }

                    for (Student s : list) {
                        int val = key.equals("Q1") ? s.q1 :
                                  key.equals("Q2") ? s.q2 : s.q3;
                        if (val == max)
                            System.out.println(s.name + " " + val);
                    }
                }

                else {

                    int maxTotal = Integer.MIN_VALUE;
                    boolean deptFound = false;

                    for (Student s : list) {
                        if (s.dept.equals(key)) {
                            deptFound = true;
                            maxTotal = Math.max(maxTotal, s.total());
                        }
                    }

                    if (!deptFound) {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for (Student s : list) {
                        if (s.dept.equals(key) && s.total() == maxTotal)
                            System.out.println(s.name + " " + maxTotal);
                    }
                }
            }
        }
    }
}