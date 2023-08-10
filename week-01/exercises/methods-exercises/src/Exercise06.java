public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(isBetween(5, 2, 8));
        System.out.println(isBetween(10, 20, 30));
        System.out.println(isBetween(15, 15, 15));
    }

    public static boolean isBetween (int a, int b, int c) {

       // return (a <= b && b <= c) || (a >= b && b >= c); - this returns if the second is between first and third
        return (b <= a && a <= c) || (c <= a && a <= b);

    }
}
