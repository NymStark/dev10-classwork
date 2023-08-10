public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(areInOrder(1,3,5,7)); //Expected: true
        System.out.println(areInOrder(1,1,1,2)); //Expected: true
        System.out.println(areInOrder(1,2,3,2)); //Expected: false
        System.out.println(areInOrder(7,5,3,1)); //Expected: false
    }

    public static boolean areInOrder (int a, int b, int c, int d) {
        return (a<=b && b<=c && c<=d);
    }
}
