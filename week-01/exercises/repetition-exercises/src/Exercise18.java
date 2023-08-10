import java.util.Scanner;

public class Exercise18 {

    public static void main(String[] args) {
        // CUT THE MIDDLE
        Scanner console = new Scanner(System.in);

        System.out.print("Phrase: ");
        String phrase = console.nextLine();

        System.out.print("Start: ");
        int start = Integer.parseInt(console.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(console.nextLine());

        // 1. Write a loop to create a new string from a phrase by "cutting out" any characters from the start index
        // to the end index.
        // 2. Print the result.

        // Examples
        // phrase, start, end -> result
        // ========================
        // "orange", 1, 2 -> "onge"
        // "orange", 3, 3 -> "orage"
        // "orange", 4, 3 -> "orange" (ignore when start is greater than end)
        // "orange", 15, 25 -> "orange" (ignore when start and end are bigger than the length of the phrase)
        // "one two three", 4, 7 -> "one three"
        // "interrupting moooo cow", 12, 17 -> "interrupting cow"

        //why is a loop needed?
        if (start < 0 || end < 0 || start > end || start >= phrase.length() || end >= phrase.length()) { //input validation.
            System.out.println("Invalid input. Cannot perform cutting.");
            return;
        }
        String result = phrase.substring(0, start) + phrase.substring(end +1 );
        System.out.println("The result is: " + result);

        //You can obviously also use concatenation, it's just slightly inefficient.
        String secondResult ="";
        for (int i = 0; i < phrase.length(); i++) {
            if (i < start || i > end) {
                secondResult += phrase.charAt(i);
            }
        }
        System.out.println("Another way gives the result of: " + secondResult);
    }
}
