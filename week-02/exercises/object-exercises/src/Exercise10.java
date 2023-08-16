import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // BALLOON GAME
        Scanner console = new Scanner(System.in);

        // 1. Instantiate three balloons of different colors.
        Balloon one = new Balloon("red");
        Balloon two = new Balloon("black")
        Balloon three = new Balloon("yellow")

        do {

            System.out.println("Inflate? [y/n]: ");
            if (console.nextLine().equalsIgnoreCase("y")) {
                // 2. If the user confirms an inflate, inflate each balloon.
                one.inflate();
                two.inflate();
                three.inflate();
            }

            // 3. When one or more balloons explode, stop the loop.
        } while (!(one.isExploded() || two.isExploded() || three.isExploded()));

        // 4. Print the color of the winners (balloons that exploded).
        if (one.isExploded()) {
            System.out.println("Red Balloon Wins!");
        }
        if (two.isExploded()) {
            System.out.println("Black Balloon Wins!");
        }
        if (three.isExploded()) {
            System.out.println("Yellow Balloon Wins!");
        }
    }
}
