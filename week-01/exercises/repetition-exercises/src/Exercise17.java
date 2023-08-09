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
        System.out.println("Please enter the rows of the box: ");
        System.out.println("Please enter the column of the box: ");
        System.out.println("Please enter a character for the border of the box: ");
        System.out.println("Please enter the character you'd like to fill your box with: ");
    }
}
