import java.util.Scanner;
public class ConnectFour {
    public static void main (String[] args) {
        System.out.println("Welcome to Connect Four!");
        Scanner scanner = new Scanner(System.in); //creates an object - scanner - to read user input
        String playerOne = getPlayerName(scanner, "Player 1");
        String playerTwo = getPlayerName(scanner, "Player 2");

        do {
            playGame (playerOne, playerTwo, scanner);
        } while (playAgain (scanner));

        System.out.println("Good Bye!!");
    }

    static String getPlayerName (Scanner scanner, String playerNumber){
        System.out.print(playerNumber + ", enter your name: ");
        return scanner.nextLine();
    }

    static void playGame() { //game play
        /*
        1. init and print board
        2. init player 1 turn, init X for player 1 symbol
        3. int moveCount = 0;
        4. game play loop - while moveCount < 42 - do shit.
                Doing shit:
                1. Get the column for the current player
                2. Attempt to drop the piece for the current player - validity checks.
                3. Print the current board.

        5. if moveCount == 42, draw.
         */

    }

    static void playAgain(){ // prompts the user with a y/n to play again

    }

    static void selectColumn(){ //Selects the column that the piece will be dropped by the player

    }

    static void initializeBoard() { //sets up the board with '_'s

    }
    static void printBoard () { //prints the board with the current settings.

    }


}
