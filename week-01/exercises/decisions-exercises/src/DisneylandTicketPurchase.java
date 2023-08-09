import java.util.Scanner;

public class DisneylandTicketPurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the buyer: ");
        String buyerName = scanner.nextLine();

        System.out.print("Enter the number of people in the group: ");
        int groupSize = scanner.nextInt();

        double totalCost = 0.0;

        for (int i = 1; i <= groupSize; i++) {
            System.out.print("Enter the age of person " + i + ": ");
            int age = scanner.nextInt();
            double ticketPrice = calculateTicketPrice(age);
            totalCost += ticketPrice;

            System.out.println("Ticket price for age " + age + ": $" + ticketPrice);
        }

        System.out.println("Total cost before discount: $" + totalCost);

        if (totalCost > 300.0) {
            double discount = totalCost * 0.10;
            totalCost -= discount;
            System.out.println("Congratulations! You've received a 10% discount.");
            System.out.println("Total cost after discount: $" + totalCost);
        }

        System.out.println("Thank you, " + buyerName + "! Enjoy your trip to Disneyland!");
    }

    static double calculateTicketPrice(int age) {
        if (age < 3) {
            return 0.0;
        } else if (age <= 14) {
            return 15.5;
        } else if (age < 65) {
            return 25.0;
        } else {
            return 15.5;
        }
    }
}