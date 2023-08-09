import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a phrase: ");
        String phrase = console.nextLine();

        // 1. Write a loop to determine if the letter `x` occurs in a user-entered phrase.
        // 2. Print a message for both finding and not finding the `x`.

        boolean findX = phrase.contains("x") || phrase.contains("X"); //covering both cases of X and x
        if (findX) {
            System.out.println("There is an x in your phase!");
        }
        else {
            System.out.println("There is no letter x found in the phrase");
        }
    }
}
