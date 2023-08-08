public class Exercise09 {

    public static void main(String[] args) {
        // 1. Write a loop to sum all numbers between 7 and 16.
        // 2. Print the result.

        int sumInclusive = 0;
        int sumExclusive = 0;
        for (int i = 7; i<=16; i++) {
            sumInclusive += i;
        }
        System.out.println("The inclusive sum is: " + sumInclusive);

        for (int i = 7+1; i<16; i++) {
            sumExclusive += i;
        }
        System.out.println("The exclusive sum is: " + sumExclusive);
    }
}
