import java.util.Random;
import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);


        // 1. Display the following menu and collect an integer choice from the user.
        // (See Exercise14 for a menu example.)
        //
        // Menu
        // 1. Print the name of an animal.
        // 2. Print the name of a state.
        // 3. Print the name of a beetle.
        // 4. Print the name of a mineral.
        // Select [1-4]:
        //
        // 2. Use a switch to cover cases 1-4 as well as a default.
        // For 1-4, print an animal, state, beetle, or mineral respectively.
        // For the default case, print "Unknown Menu Option".

        System.out.println("Menu");
        System.out.println("===================================");
        System.out.println("1. Prints the name of an animal.");
        System.out.println("2. Prints the name of a state.");
        System.out.println("3. Prints the name of a beetle.");
        System.out.println("4. Prints the name of a mineral.");
        System.out.print("Select [1-4]: ");

        int choice = Integer.parseInt(console.nextLine());
        Random random = new Random();

//        normal switch
//        switch (choice) {
//            case 1:
//                System.out.println("Animal: Tiger");
//                break;
//            case 2:
//                System.out.println("State: California");
//                break;
//            case 3:
//                System.out.println("Beetle: Ladybug");
//                break;
//            case 4:
//                System.out.println("Mineral: Diamond");
//                break;
//            default:
//                System.out.println("Unknown Menu Option");
//                break;
//        }

//        Enhanced Switch
//        switch (choice) {
//            case 1 -> System.out.println("Animal: Tiger");
//            case 2 -> System.out.println("State: California");
//            case 3 -> System.out.println("Beetle: Ladybug");
//            case 4 -> System.out.println("Mineral: Diamond");
//            default -> System.out.println("Unknown Menu Option");
//        }

        switch (choice) {
            case 1:
                String[] animals = {"Tiger", "Lion", "Elephant"}; // Any available options for the array
                int animalIndex = random.nextInt(animals.length); // assign a random index number, depending on array length
                System.out.println("Animal: " + animals[animalIndex]); // prints the string corresponding to the index.
                break;
            case 2:
                String[] states = {"California", "New York", "Texas"};
                int stateIndex = random.nextInt(states.length);
                System.out.println("State: " + states[stateIndex]);
                break;
            case 3:
                String[] beetles = {"Ladybug", "Scarab", "Firefly"};
                int beetleIndex = random.nextInt(beetles.length);
                System.out.println("Beetle: " + beetles[beetleIndex]);
                break;
            case 4:
                String[] minerals = {"Diamond", "Gold", "Quartz"};
                int mineralIndex = random.nextInt(minerals.length);
                System.out.println("Mineral: " + minerals[mineralIndex]);
                break;
            default:
                System.out.println("Unknown Menu Option");
                break;
        }
    }
}
