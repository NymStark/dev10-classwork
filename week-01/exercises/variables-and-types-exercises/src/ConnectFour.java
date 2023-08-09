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

    static void playGame(String playerOne, String playerTwo, Scanner scanner) { //game play

//        1. init and print board

        char[][] board = new char[6][7];
        initializeBoard(board);

//        2. init player 1 turn, init X for player 1 symbol

        boolean playerOneTurn = true;
        char curPlayerSymbol = 'X';
        printBoard(board);

//        3. int moveCount = 0;
        int moveCount = 0;

//        4. game play loop - while moveCount < 42 - do shit.
//                Doing shit:
//                1. Get the column for the current player
//                2. Attempt to drop the piece for the current player - validity checks.
//                3. Print the current board.
//                4. Check for the win
        while (moveCount < 42) {
            int column = selectColumn(scanner, playerOneTurn, playerOne, playerTwo, board); //assigning the column that we're getting from the input via selectColumn method
            int row = dropPiece(board, column, curPlayerSymbol);
            if (row != -1) {
                printBoard(board); //if the piece can be dropped, drop it, and print the board.
                char symbol = curPlayerSymbol;

                if (checkWinAfterDrop(board, row, column, symbol)) {
                    String winner = playerOneTurn ? playerOne : playerTwo;
                    System.out.println(winner + " wins!");
                    return; // Exit the game loop
                }
                //switch playerOneTurn, and curPlayerSymbol:
                playerOneTurn = !playerOneTurn;
                curPlayerSymbol = (curPlayerSymbol == 'X') ? 'O' : 'X';
                moveCount++;
            }

        }
//        5. if moveCount == 42, draw.
        if (moveCount == 42) {
            System.out.println("It's a draw!!!!");
        }

    }

    static boolean playAgain(Scanner scanner){ // prompts the user with a y/n to play again
        System.out.print("Play Again? [y/n]: ");
        return scanner.next().equalsIgnoreCase("y"); // returns true if y,

    }

    static int selectColumn(Scanner scanner, boolean playerOneTurn, String playerOne, String playerTwo, char[][] board ){ //Selects the column that the piece will be dropped by the player
        String curPlayer = playerOneTurn ? playerOne : playerTwo;
        System.out.print( curPlayer + ", enter the column (1-7):  ");
        int column;
        do {
            column = scanner.nextInt() -1; //subtracting 1 to convert the array index
            if (column < 0 || column >= 7) {
                System.out.println("Invalid option. Enter a number between 1 and 7");
            }
            else if (board[0][column] != '_'){
                System.out.println("Column is full, please choose another");
            }

        } while (column < 0 || column >=7 || board[0][column] != '_'); // Repeat until a valid column is chosen


        return column;
    }
    static int dropPiece(char[][] board, int column, char symbol) {
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == '_') {
                board[row][column] = symbol; // Place the piece in the first available row
                return row; // Successfully placed the piece, returns the row which the piece was dropped
            }
        }
        return -1; // Column is full, couldn't place the piece
    }

    static void initializeBoard( char[][] board) { //sets up the board with '_'s
        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 7; col ++) {
                board[row][col] = '_'; //Initializing the board with underscores
            }
        }

    }
    static void printBoard (char[][] board) { //prints the board with the current settings.
        System.out.println(" 1 2 3 4 5 6 7");
        for (int row = 0; row < 6; row ++){
            for (int col = 0; col < 7; col++) {
                System.out.print( " " + board[row][col]);
            }
            System.out.println();
        }
    }

    static boolean checkWinAfterDrop(char[][] board, int row, int col, char symbol){ //checks for horizontal, vertical, and diagonal wins.
        int[][] directions = {
            {0, 1}, //Horizontal
            {1, 0}, //Vertical
            {1, 1}, //Diagonal top left to bottom right
            {1,-1}  //Diagonal top right to bottom left
        };
        for (int[] dir: directions) {
            int deltaRow = dir[0];
            int deltaColumn = dir[1];
            if (checkDirection(board, row, col, symbol, deltaRow, deltaColumn)) {
                return true;
            }
        }
        return false;
    }
    static boolean isValidCell(int row, int col) { // Checks if the row and columns are inside the board, no out of bounds shenanigans
        return row >= 0 && row < 6 && col >= 0 && col < 7;
    }

    static boolean checkDirection(char[][] board, int row, int col, char symbol, int deltaRow, int deltaColumn) {
        int count = 0;
        for (int i = -3; i <= 3; i++) {
            int r = row + i*deltaRow;
            int c = col + i*deltaColumn;

            if(isValidCell(r, c) && board[r][c] == symbol) {
                count++;

            if (count >= 4) {
                return true;
            }
        } else {
                count = 0;
            }
        }
        return false; //return false as no win is found in current direction
    }


}
