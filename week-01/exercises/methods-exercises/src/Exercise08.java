public class Exercise08 {

    // 1. Create a method.
    // Name: getRandomFruit
    // Inputs: none
    // Output: String
    // Description: returns a random fruit name as a string.
    // See Exercise01.
    // Choose from at least 5 fruit.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
        System.out.println(getRandomFruit());
    }

    public static String getRandomFruit() {
        switch ((int) (Math.random() * 10)) {
            case 0:
                return "Banana";
            case 1:
                return "Apple";
            case 2:
                return "Dragon Fruit";
            case 3:
                return "Strawberry";
            case 4:
                return "Blueberry";
            case 5:
                return "Raspberry";
            case 6:
                return "Watermelon";
            case 7:
                return "Mango";
            case 8:
                return "Avocado";
            case 9:
                return "Tomato";
        }

        return ""; //Should never happen
    }
}
