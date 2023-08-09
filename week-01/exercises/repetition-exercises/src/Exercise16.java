import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // BORDER BOX
        // 1. Use nested loops to print a box in the console with a different character for the border.
        // One loop should represent rows and the other should represent columns.
        // The border character should be different from the internal box character.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // *****
        // *###*
        // *###*
        // *###*
        // *****

        // (3X4)
        // ****
        // *##*
        // ****

        // (2X2)
        // **
        // **

        Scanner console = new Scanner(System.in);

        System.out.print("Columns of the box: ");
        int columns = Integer.parseInt(console.nextLine());
        System.out.println("Rows of the box : ");
        int rows = Integer.parseInt(console.nextLine());

        for (int i = 1; i <= rows; i++ ) {
            for (int j = 1; j <= columns; j++) {
                if (i == 1 || i == rows || j == 1 || j == columns) { //parameters for the borders.
                    System.out.print("*");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }

    }
}
