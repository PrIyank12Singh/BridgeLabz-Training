import java.util.Stack;

public class BrowserBuddy {

    // History Node
    static class PageNode {
        String url;
        PageNode prev;
        PageNode next;

        PageNode(String url) {
            this.url = url;
        }
    }

    // Tab History
    static class TabHistory {

        private PageNode current;

        // Visit new page
        public void visit(String url) {
            PageNode newNode = new PageNode(url);

            if (current != null) {
                current.next = null;   // clear forward history
                newNode.prev = current;
                current.next = newNode;
            }

            current = newNode;
            System.out.println("Visited: " + url);
        }

        // Go back
        public void back() {
            if (current != null && current.prev != null) {
                current = current.prev;
                System.out.println("Back to: " + current.url);
            } else {
                System.out.println("No previous page");
            }
        }

        // Go forward
        public void forward() {
            if (current != null && current.next != null) {
                current = current.next;
                System.out.println("Forward to: " + current.url);
            } else {
                System.out.println("No forward page");
            }
        }

        public String getCurrentPage() {
            return current != null ? current.url : null;
        }
    }

    // Tab Manager
    static class BrowserManager {

        private TabHistory currentTab = new TabHistory();
        private Stack<TabHistory> closedTabs = new Stack<>();

        public TabHistory getCurrentTab() {
            return currentTab;
        }

        // Close current tab
        public void closeTab() {
            closedTabs.push(currentTab);
            currentTab = new TabHistory();
            System.out.println("Tab closed.");
        }

        // Restore tab
        public void restoreTab() {
            if (!closedTabs.isEmpty()) {
                currentTab = closedTabs.pop();
                System.out.println("Tab restored. Current page: " +
                        currentTab.getCurrentPage());
            } else {
                System.out.println("No tabs to restore.");
            }
        }
    }

    //Main
    public static void main(String[] args) {

        BrowserManager manager = new BrowserManager();
        TabHistory tab = manager.getCurrentTab();

        tab.visit("google.com");
        tab.visit("github.com");
        tab.visit("stackoverflow.com");

        tab.back();
        tab.back();
        tab.forward();

        manager.closeTab();

        manager.restoreTab();
    }
}
