import java.util.Scanner;

public class Exercise17 {

    public static void main(String[] args) {
        // USER-DEFINED BOX
        // 1. Collect the following from a user: rows, columns, box character, border character.
        // 2. Use nested loops to print a user-defined box in the console.
        // (See Exercise16.)

        Scanner console = new Scanner(System.in);

        System.out.println("*********************************************");
        System.out.println("** Welcome to creating your personal box!! **");
        System.out.println("*********************************************");
        System.out.println();
        System.out.print("Please enter the rows of the box: ");
        int rows = Integer.parseInt(console.nextLine());
        System.out.print("Please enter the column of the box: ");
        int columns = Integer.parseInt(console.nextLine());
        System.out.print("Please enter a character for the border of the box: ");
        char border = console.nextLine().charAt(0);
        System.out.print("Please enter the character you'd like to fill your box with: ");
        char fillCharacter = console.nextLine().charAt(0);

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i == 1 || i == rows || j == 1 || j == columns) {
                    System.out.print(border);
                } else {
                    System.out.print(fillCharacter);
                }
            }
            System.out.println();
        }
    }
}
