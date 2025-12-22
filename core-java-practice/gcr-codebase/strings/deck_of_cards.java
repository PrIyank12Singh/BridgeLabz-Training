
  import java.util.Scanner;

public class deck_of_cards {

    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public static String[] initializeDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int k = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[k++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) return null;

        String[][] playerCards = new String[players][cardsPerPlayer];
        int k = 0;
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards[i][j] = deck[k++];
            }
        }
        return playerCards;
    }

    public static void displayPlayers(String[][] playerCards) {
        for (int i = 0; i < playerCards.length; i++) {
            System.out.println("Player " + (i+1) + ":");
            for (String card : playerCards[i]) System.out.print(card + ", ");
            System.out.println("\n---------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        
        int players = scan.nextInt();
        System.out.println("Enter number of cards per player:");
        int cardsPerPlayer = scan.nextInt();

        String[][] playerCards = distributeCards(deck, players, cardsPerPlayer);
        if (playerCards != null) displayPlayers(playerCards);
        else System.out.println("Not enough cards to distribute.");

        scan.close();
    }
  }

