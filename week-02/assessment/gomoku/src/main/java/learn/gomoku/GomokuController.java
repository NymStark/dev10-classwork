package learn.gomoku;

import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.Player;
import learn.gomoku.players.HumanPlayer;

import java.util.List;
import java.util.Scanner;

public class GomokuController {
    private Gomoku game;
    private final Scanner scanner;
//    private Player playerOne; // Declare playerOne at the class level
//    private Player playerTwo; // Declare playerTwo at the class level
//    private Player currentPlayer; //to track the current player.


    public GomokuController(Player playerOne, Player playerTwo) {
        game = new Gomoku(playerOne, playerTwo);
        scanner = new Scanner(System.in);
//        if (Math.random() < 0.5) {
//            game.swap(); // Switch players if playerTwo goes first
//        }
//        currentPlayer = playerOne;
    }


    //Building up Methods
    //Let's start with the ones that aren't related to each other first
    /*
    1. selectPlayer()
    2. asktoPlayAgain()
    3. printBoard()
    4. getPlayerName() <--- not quite neccessary, but maybe.
    5. getPlayerMove()
    6. Check win - already implemented.
    7. playGame() --- putting everything together
     */
    /*
    Fixes - moved player initialization to main
    Move player selection methods into App.
     */
    public void playGame() {
//
//
//        Player playerOne = selectPlayer(1);
//        Player playerTwo = selectPlayer(2);
//        game = new Gomoku(playerOne, playerTwo);
        while (!game.isOver()) { //while the game is not over
            displayBoard(); // display the current board state
            Stone move = getPlayerMove(); //perform getPlayermove to obtain the Stone object

//            if (game.getCurrent() instanceof HumanPlayer) {
//                move = getPlayerMove();
//            } else {
//                move = game.getCurrent().generateMove(game.getStones());
//                //game.getCurrent = current player.
//                //generateMove - generating move for RandomPlayer to the List getStones()
//            }

             Result result = game.place(move); //place the move.
            if (!result.isSuccess()){
                System.out.println(result.getMessage() + " Invalid move, row: " + (move.getRow()+1) + " column: " + (move.getColumn()+1) );
            }
        }

        displayBoard();
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        if (askToPlayAgain()) {
            playGame();
        }
    }

//    private Player selectPlayer(int playerNumber) {
//        System.out.println("Player " + playerNumber + ", choose a player type: ");
//        System.out.println("1. Human Player");
//        System.out.println("2. Random Player");
//        int choice;
//        while (true) {
//            System.out.print("Enter your choice (1-2): ");
//            try {
//                choice = Integer.parseInt(scanner.nextLine());
//                if (choice == 1) {
//                    System.out.print("Enter your name: ");
//                    String playerName = scanner.nextLine();
//                    return new HumanPlayer(playerName);
//                } else if (choice == 2) {
//                    return new RandomPlayer();
//                } else {
//                    System.out.println("Invalid choice. Please enter 1 for Human Player or 2 for Random Player.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//            }
//        }
//    }

    private boolean askToPlayAgain() {
        System.out.print("Play again? (y/n): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("y")) {
            return true;
        } else {
            System.out.println("Thanks for playing!");
            return false;
        }
    }

//    Creating main method to test the board.
//    public static void main(String[] args) {
//        // Create two players (you can replace these with actual player instances)
//        Player playerOne = new HumanPlayer("Player 1");
//        Player playerTwo = new RandomPlayer();
//
//        // Create a GomokuController
//        GomokuController controller = new GomokuController(playerOne, playerTwo);
//
//        // Test the displayBoard method
//        controller.displayBoard();
//    }

    private void displayBoard() {
        char[][] board = new char[Gomoku.WIDTH][Gomoku.WIDTH];
        // init board with empty spaces
        for (int i = 0; i < Gomoku.WIDTH; i++) {
            for (int j = 0; j < Gomoku.WIDTH; j++) {
                board[i][j] = '_';
            }
        }

        List<Stone> stones = game.getStones();
        //Getting the stones from the game
        //I completely overlooked this method, I kept wondering how to access the stones.
        for (Stone stone : stones) {
            int row = stone.getRow();
            int column = stone.getColumn();
            char symbol = stone.isBlack() ? 'X' : '0';
            board[row][column] = symbol;
        }

        // printing out the board with two digit numbers instead of single, for alignment purposes.
        // Column numbers
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < Gomoku.WIDTH; i++) {
            System.out.print(String.format("%02d ", i + 1));
            // Print as two-digit numbers, we are printing the column number first.
        }
        System.out.println();

        // Print row numbers and game board cells
        for (int i = 0; i < Gomoku.WIDTH; i++) {
            System.out.print(String.format("%02d ", i + 1));
            // Print as two-digit numbers, we are printing the double digit row numbers first, before entering the inner loop.
            for (int j = 0; j < Gomoku.WIDTH; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }


    private Stone getHumanPlayerMove() {
        //initially thought this was just wrong, but it gets the player to input the move, combined to getPlayerMove().
      //  Player currentPlayer = game.getCurrent();
//        System.out.println(currentPlayer.getName() + " to move.");

        Stone move = null;

        while (move==null) {
            try {
                System.out.print("Enter row: ");
                int row = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.print("Enter column: ");
                int column = Integer.parseInt(scanner.nextLine()) - 1;

                move = new Stone(row, column, game.isBlacksTurn());
//                Result result = game.place(move);
//                if (!result.isSuccess()) {
//                    System.out.println(result.getMessage());
//                    move = null;
//                }
                //lines above are superfluous, game.place(move) is called inside the playGame method.

            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter valid inputs.");
            }
        }
        return move;
    }

    private Stone getPlayerMove() {
        Player currentPlayer = game.getCurrent();
        System.out.println(currentPlayer.getName() + " to move.");
        Stone move = null;

        while (move == null) {
            if (currentPlayer instanceof HumanPlayer) {
                move = getHumanPlayerMove();
            } else {
                move = currentPlayer.generateMove(game.getStones());
            }

            if (move == null) {
                System.out.println("Invalid move.");
            }
        }

        return move;
    }
}

