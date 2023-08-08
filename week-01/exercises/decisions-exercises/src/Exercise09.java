import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter the minimum value: ");
        int minValue = Integer.parseInt(console.nextLine());

        System.out.println("Enter the maximum value: ");
        int maxValue = Integer.parseInt(console.nextLine());

        System.out.println("Enter the actual value: ");
        int actualValue = Integer.parseInt(console.nextLine());

        if (actualValue >= minValue && actualValue <= maxValue) {
            System.out.println("Great job, you know how to find a number between two other numbers!!!");
        } else {
            System.out.println("Failure. Small number, big number, between the numbers!! GG small brains.");
        }


    }
}
