public class Exercise10 {
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.
    public static void main(String[] args) {
        String text1 = "   Hello,   World!   ";
        String result1 = removeWhiteSpaces(text1);
        System.out.println("Original: " + text1);
        System.out.println("Without White Spaces: " + result1);

        String text2 = " Java Programming  ";
        String result2 = removeWhiteSpaces(text2);
        System.out.println("Original: " + text2);
        System.out.println("Without White Spaces: " + result2);

    }

    public static String removeWhiteSpaces(String s){
        return s.replaceAll("\\s","");
        // looked up documentations
        // replaceALL method is just that.
        // \\s is basically a whitespace character, including tabs.
    }
}
