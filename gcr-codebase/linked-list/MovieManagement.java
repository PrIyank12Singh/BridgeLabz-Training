import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        next = prev = null;
    }
}

class MovieDoublyList {
    private MovieNode head, tail;

    // add at end
    void addMovie(MovieNode node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    // delete by title
    void deleteByTitle(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title))
            temp = temp.next;

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

        if (temp == head)
            head = temp.next;
        if (temp == tail)
            tail = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp.next != null)
            temp.next.prev = temp.prev;

        System.out.println("Movie deleted");
    }

    // search by director
    void searchByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director))
                print(temp);
            temp = temp.next;
        }
    }

    // update rating
    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // display forward
    void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            print(temp);
            temp = temp.next;
        }
    }

    // display reverse
    void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            print(temp);
            temp = temp.prev;
        }
    }

    void print(MovieNode m) {
        System.out.println(
            m.title + " | " + m.director + " | " + m.year + " | " + m.rating
        );
    }
}

public class MovieManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyList list = new MovieDoublyList();

        while (true) {
            System.out.println("\n1.Add 2.Delete 3.Search Director 4.Update Rating 5.Forward 6.Reverse 7.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    list.addMovie(new MovieNode(
                        sc.next(), sc.next(), sc.nextInt(), sc.nextDouble()));
                    break;
                case 2:
                    list.deleteByTitle(sc.next());
                    break;
                case 3:
                    list.searchByDirector(sc.next());
                    break;
                case 4:
                    list.updateRating(sc.next(), sc.nextDouble());
                    break;
                case 5:
                    list.displayForward();
                    break;
                case 6:
                    list.displayReverse();
                    break;
                case 7:
                    sc.close();
                    return;
            }
        }
    }
}
