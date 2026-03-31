import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        prev = next = null;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private int size = 0;
    private final int MAX = 10;

    // add new state
    void addState(String text) {
        TextState node = new TextState(text);

        if (head == null) {
            head = tail = current = node;
            size = 1;
            return;
        }

        // remove redo history
        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        current = node;
        size++;

        // Limit history
        if (size > MAX) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // undo
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo");
        }
    }

    // redo
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo");
        }
    }

    // display current text
    void display() {
        if (current == null)
            System.out.println("Empty Editor");
        else
            System.out.println("Current Text: " + current.content);
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n1.Type 2.Undo 3.Redo 4.Display 5.Exit");
            int ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) {
                case 1:
                    editor.addState(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.display();
                    break;
                case 5:
                    sc.close();
                    return;
            }
        }
    }
}
