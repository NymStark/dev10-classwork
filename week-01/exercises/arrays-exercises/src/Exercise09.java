public class Exercise09 {

    public static void main(String[] args) {
        String[] haystack = makeHaystack();

        // A needle is randomly placed in a haystack array with a capacity of 100.
        // 1. Loop through the haystack and find the needle.
        // 2. Print the index where you found it.
        // Hint: this is an exercise about the default value of strings.
        int index = findNeedle(haystack);
        if (index != -1) {
            System.out.println("Need found at index " + index);
        } else {
            System.out.println("Needle is not found.");
        }
    }

    public static String[] makeHaystack() {
        String[] haystack = new String[100];
        int index = (int) (Math.random() * haystack.length);
        haystack[index] = "needle";
        return haystack;
    }

    public static int findNeedle(String[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("needle")){
                return i;
            }
        }
        return -1; //not found.
    }
}
