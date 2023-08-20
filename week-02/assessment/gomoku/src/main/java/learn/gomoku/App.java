package learn.gomoku;

import learn.gomoku.players.Player;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.RandomPlayer;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to Gomoku!");
        Scanner scanner = new Scanner(System.in);

        // get player types
        Player playerOne = selectPlayer(scanner, 1);
        Player playerTwo = selectPlayer(scanner, 2);

        // initialize the controller with the selected players
        GomokuController controller = new GomokuController(playerOne, playerTwo);

        // Start the game
        controller.playGame();

        scanner.close();
    }

    // moving selectPlayer to App to handle a bit of separation of concerns.
    private static Player selectPlayer(Scanner scanner, int playerNumber) {
        System.out.println("Player " + playerNumber + ", choose a player type: ");
        System.out.println("1. Human Player");
        System.out.println("2. Random Player");

        int choice;
        while (true) {
            System.out.print("Enter your choice (1-2): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    System.out.print("Enter your name: ");
                    String playerName = scanner.nextLine();
                    return new HumanPlayer(playerName);
                } else if (choice == 2) {
                    return new RandomPlayer();
                } else {
                    System.out.println("Invalid choice. Please enter 1 for Human Player or 2 for Random Player.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}