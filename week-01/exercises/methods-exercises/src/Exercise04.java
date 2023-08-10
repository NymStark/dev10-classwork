public class Exercise04 {

    public static void main(String[] args) {
        System.out.println(getFirstVowel("magnificent")); // Expected: a
        System.out.println(getFirstVowel("winsome")); // Expected: i
        System.out.println(getFirstVowel("xxx")); // Expected:

        // 2. Call getFirstVowel at least one more time.
    }

    // getFirstVowel returns the first vowel in a string as a char.
    // 1. Complete getFirstVowel.
    // If no vowel is found, return 0. (As a char, 0 represents the NULL value.)
    public static char getFirstVowel(String value) {
        int i = 0;
        while (i < value.length()) {
            char cur = value.charAt(i);
            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u' ||
                    cur == 'A' || cur == 'E' || cur == 'I' || cur == 'O' || cur == 'U') {
                return cur; // Return the first vowel found.
            }
            i++;
        }
        return 0; // Return 0 if no vowel is found.
    }
}
