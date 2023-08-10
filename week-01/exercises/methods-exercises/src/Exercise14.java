import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise14 {
    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */
    public static void main(String[] args) {
        String firstName = askQuestion("What is your first name?");
        String lastName = askQuestion("What is your last name?");
        int townsLivedIn = askIntQuestion("How many towns/cities have you lived in?");
        int instrumentsPlayed = askIntQuestion("How many musical instruments can you play?");

        printResults( firstName, lastName, townsLivedIn, instrumentsPlayed);
    }

    public static String askQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question + " ");
        return scanner.nextLine();
    }

    public static int askIntQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question + " ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void printResults(String firstname, String lastname, int townslivedin, int instrumentsplayed) {
        System.out.println("Some of your informations: ");
        System.out.println();
        System.out.println("First Name: " + firstname);
        System.out.println("Last Name: " + lastname);
        System.out.println("Number of towns you lived in: " + townslivedin);
        System.out.println("Number of instruments you play: " + instrumentsplayed);
    }



}
