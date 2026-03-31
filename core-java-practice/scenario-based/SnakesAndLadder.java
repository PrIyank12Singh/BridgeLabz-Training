import java.util.Random;

public class SnakesAndLadder {

    static final int winning_position = 100;

  
    static int rollDie(Random random) {
        return random.nextInt(6) + 1;
    }

  
    static int getOption(Random random) {
        return random.nextInt(3);
    }

    public static void main(String[] args) {

        Random random = new Random();

        int player1Position = 0;
        int player2Position = 0;

        int diceCountPlayer1 = 0;
        int diceCountPlayer2 = 0;

        boolean isPlayer1Turn = true;

        while (player1Position < winning_position && player2Position < winning_position) {

            int die = rollDie(random);
            int option = getOption(random);

            if (isPlayer1Turn) {
                diceCountPlayer1++;
                System.out.println("\nPlayer 1 rolls die: " + die);

                int oldPosition = player1Position;

                if (option == 1) { 
                    player1Position += die;
                    System.out.println("Player 1 got Ladder");

                } else if (option == 2) {
                    player1Position -= die;
                    System.out.println("Player 1 got Snake");

                } else {
                    System.out.println("Player 1 got No Play");
                }

                
                if (player1Position < 0) {
                    player1Position = 0;
                }

                
                if (player1Position >winning_position) {
                    player1Position = oldPosition;
                }

                System.out.println("Player 1 position: " + player1Position);

                
                if (option != 1) {
                    isPlayer1Turn = false;
                }

            } else {
                diceCountPlayer2++;
                System.out.println("\nPlayer 2 rolls die: " + die);

                int oldPosition = player2Position;

                if (option == 1) { 
                    player2Position += die;
                    System.out.println("Player 2 got Ladder");

                } else if (option == 2) {
                    player2Position -= die;
                    System.out.println("Player 2 got Snake");

                } else {
                    System.out.println("Player 2 got No Play");
                }

                
                if (player2Position < 0) {
                    player2Position = 0;
                }

              
                if (player2Position > winning_position) {
                    player2Position = oldPosition;
                }

                System.out.println("Player 2 position: " + player2Position);

                
                if (option != 1) {
                    isPlayer1Turn = true;
                }
            }
        }

        
        System.out.println("GAME OVER");

        if (player1Position == winning_position) {
            System.out.println("Player 1 WON the game!");
            System.out.println("Dice rolls by Player 1: " + diceCountPlayer1);
        } else {
            System.out.println("Player 2 WON the game!");
            System.out.println("Dice rolls by Player 2: " + diceCountPlayer2);
        }
    }
}
