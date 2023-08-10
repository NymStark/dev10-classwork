import java.util.Scanner;

public class Exercise12 {

    // 1. Create a method.
    // Name: readRequiredString
    // Inputs: String
    // Output: String
    // Description: prompts a user to enter a required string and returns their validated input.
    // The parameter is the message displayed to the user.
    //
    // See the readRequiredString implementation in the methods lesson.
    // You can definitely improve it. Make sure you don't allow blank input. Checking the length() is not enough.

    // 2. Create a method.
    // Name: printNounPhrase
    // Inputs: none
    // Output: none
    // Description: prints an adjective + noun phrase to the console based on user input.
    // Internally, prompts a user for an adjective and a noun with readRequiredString.
    // Concatenates adjective and noun and prints it to the console.

    public static void main(String[] args) {
        // 3. Uncomment the code below and confirm it works.
         printNounPhrase();
         printNounPhrase();
         printNounPhrase();
    }

    public static String readRequiredString(String prompt) {
        Scanner console = new Scanner(System.in);
        String result;
        do {
            System.out.print(prompt);
            result = console.nextLine().trim(); //trims off white spaces afterwards

            if (result.isEmpty()) {
                System.out.println("You didn't enter anything. Please try again.");
            } else if (!isValidInput(result)) {
                System.out.println("Invalid input. Please enter letters and numbers only.");
            }
        } while (!isValidInput(result));
        return result;
    }

    public static boolean isValidInput(String input) {
        return input.matches("[a-zA-Z0-9]+"); //this is so wild.
    }

    public static void printNounPhrase(){
        String adjective = readRequiredString("Enter an adjective: ");
        String noun = readRequiredString("Enter a noun: ");
        String nounPhrase = adjective + " " + noun;
        System.out.println("Noun phrase: " + nounPhrase);
    }
}
