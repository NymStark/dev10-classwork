import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // SWITCH OPPOSITES
        // Given a word, print its opposite using a switch statement.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = console.nextLine();
        String opposite = null;

        // 1. Re-implement Exercise08 using a switch statement.
        switch (word) {
            case "up":
                opposite = "down";
                break;
            case "down":
                opposite = "up";
                break;
            case "left":
                opposite = "right";
                break;
            case "right":
                opposite = "left";
                break;
            case "good":
                opposite = "bad";
                break;
            case "bad":
                opposite = "good";
                break;
            case "hot":
                opposite = "cold";
                break;
            case "cold":
                opposite = "hot";
                break;
            case "happy":
                opposite = "sad";
                break;
            case "sad":
                opposite = "happy";
                break;
            default:
                opposite = "I don't know the opposite of that word.";
                break;
        }

        System.out.println("The opposite of '" + word + "' is '" + opposite + "'.");
    }
}
