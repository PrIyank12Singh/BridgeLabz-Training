import java.util.Scanner;

class StudentNode {
    int roll;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    // add at beginning
    void addAtBeginning(StudentNode newNode) {
        newNode.next = head;
        head = newNode;
    }

    // add at end
    void addAtEnd(StudentNode newNode) {
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // delete by roll number
    void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        StudentNode curr = head;
        while (curr.next != null && curr.next.roll != roll)
            curr = curr.next;

        if (curr.next == null) {
            System.out.println("Student not found");
        } else {
            curr.next = curr.next.next;
            System.out.println("Student deleted");
        }
    }

    // search
    void search(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.name + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // update grade
    void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // display
    void display() {
        if (head == null) {
            System.out.println("No student records");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            System.out.println(
                temp.roll + " | " + temp.name + " | " + temp.age + " | " + temp.grade
            );
            temp = temp.next;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        while (true) {
            System.out.println("\n1.Add 2.Delete 3.Search 4.Update Grade 5.Display 6.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll Name Age Grade: ");
                    list.addAtEnd(new StudentNode(
                            sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0)));
                    break;
                case 2:
                    System.out.print("Roll: ");
                    list.deleteByRoll(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Roll: ");
                    list.search(sc.nextInt());
                    break;
                case 4:
                    System.out.print("Roll NewGrade: ");
                    list.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    sc.close();
                    return;
            }

            
        }

        
    }
}
