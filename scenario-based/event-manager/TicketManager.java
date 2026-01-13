class TicketManager {

    private Ticket[] tickets;
    private int size;

    public TicketManager(int capacity) {
        tickets = new Ticket[capacity];
        size = 0;
    }

    public void addTicket(Ticket t) {
        if (size == tickets.length) {
            System.out.println("Ticket storage full.");
            return;
        }
        tickets[size++] = t;
    }

    public void sortByPrice() {
        if (size > 1) {
            quickSort(0, size - 1);
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int p = partition(low, high);

            quickSort(low, p - 1);
            quickSort(p + 1, high);
        }
    }

    private int partition(int low, int high) {

        double pivot = tickets[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Ticket temp = tickets[i];
        tickets[i] = tickets[j];
        tickets[j] = temp;
    }

    public void displayTopCheapest(int k) {
        System.out.println("\nTop " + k + " Cheapest Tickets:");
        for (int i = 0; i < k && i < size; i++) {
            tickets[i].display();
        }
    }

    public void displayTopExpensive(int k) {
        System.out.println("\nTop " + k + " Most Expensive Tickets:");
        for (int i = size - 1; i >= size - k && i >= 0; i--) {
            tickets[i].display();
        }
    }

    public void displayAll() {
        for (int i = 0; i < size; i++) {
            tickets[i].display();
        }
    }
}
