import java.util.Scanner;

public class Exercise13 {

    public static void main(String[] args) {
        // NEEDLE & HAYSTACK
        Scanner console = new Scanner(System.in);

        System.out.print("Needle: ");
        String needle = console.nextLine();

        System.out.print("Haystack: ");
        String haystack = console.nextLine();

        // 1. Given two string variables: needle and haystack, determine if haystack contains needle.
        // Examples
        // needle  haystack contains?
        //     an      bean      yes
        //    een      bean       no
        //    ury   Mercury      yes
        //    ury     curry       no
        //    mer   Mercury       no (case sensitive)
        // 2. As a stretch goal, display the location (index) of needle in haystack.

        // methods: contains()  :   Runs through a string to check if a specific sequence of characters exists within a larger string
        //          indexOf()   :   Also a member of the String class (in Java). It locates the index of a specific substring within a given string.
        //                          It returns the index of the first occurrence of the specified substring, else -1

        if (haystack.contains(needle)) {
            System.out.println("Haystack contains the needle.");

            // Display the index of needle in haystack
            int index = haystack.indexOf(needle);
            System.out.println("The needle is found at index: " + index);
        } else {
            System.out.println("Haystack does not contain the needle.");
        }

    }
}
