import java.util.Scanner;

/*
    1. The goal is to create a hotel capsule management
    2. Data structure will be simple string array.
    3. Reusable methods to help with functionality:
    initializeCapsules - populate the capsule with "Vacant"
    check-in: Our checking in method
    check-out: Our checking out method
    displayOccupancy: Occupancy display method
    confirmExit: Our exit options confirmation
    getPositiveInteger: We are working with mostly integer inputs, this method should be sufficient
    Stretch - maybe also have only proper characters for the guestName?
 */
public class HanoiCapsuleManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Welcome msgs
        System.out.println("===========================");
        System.out.println("Welcome to Hanoi Capsules!!");
        System.out.println("===========================");
        System.out.print("Enter the amount of capsules available: ");
        int numberOfCapsules = getPositiveInteger(scanner);

        String[] capsules = new String[numberOfCapsules];
        initializecapsules(capsules);

        boolean exit = false; //exit condition
        while (!exit) {
            displayMenu();
            int choice = getPositiveInteger(scanner);

            switch(choice) {
                case 1:
                    checkIn(capsules, scanner);
                    break;
                case 2:
                    checkOut(capsules, scanner);
                    break;
                case 3:
                    displayOccupancy(capsules, scanner);
                    break;
                case 4:
                    if (confirmExit(scanner)) {
                        exit = true;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option");
            }
        }

    }

    public static void initializecapsules(String[] capsules){
        for (int i=0; i < capsules.length; i++){
            capsules[i] = "Vacant";
        }
    }

    public static void displayMenu() { //prints the display.
        System.out.println("==============");
        System.out.println("**Guest Menu**");
        System.out.println("==============");
        System.out.println("1. Checking In");
        System.out.println("2. Checking Out");
        System.out.println("3. Display Occupancy");
        System.out.println("4. Exit");
        System.out.print("Select an option [1-4]: ");
    }

    public static void checkIn(String[] capsules, Scanner scanner){
        //this method checks for the number of empty room and displays it.
        //if there are no available rooms, exit. "We're sorry but our capsules are fully occupied"
        //Prompts the user for a name:
        //Prompts the user for a room preference:
        //If the room is available. update the name to the correct position
        //If the room is unavailable ask them to put in another room until an available room is found.

        System.out.println("===============");
        System.out.println("**Checking in**");
        System.out.println("===============");
        int availableRooms = 0;
        for (String capsule: capsules) {
            if (capsule.equals("Vacant")){
                availableRooms++;
            }
        }
        if (availableRooms==0){
            System.out.println("We are sorry, but our capsules are fully occupied right now.");
            return; //return to menu or display error.
        }
        System.out.println("The Number of available rooms is: " + availableRooms);
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();

        int preferredRoom;
        boolean validRoom;

        do {
            System.out.print("Enter the room the guest would prefer: ");
            preferredRoom = getPositiveInteger(scanner) - 1; //Adjusting index
            validRoom = preferredRoom >= 0 && preferredRoom < capsules.length && capsules[preferredRoom].equals("Vacant");

            if(!validRoom){
                System.out.println("Not available.");
            }

        } while (!validRoom);

        capsules[preferredRoom] = guestName;
        System.out.println("Check-in Successful! ");
    }

    public static void checkOut(String[] capsules, Scanner scanner){
//        - Enter Room Number:
//        - Invalid number check
//        - Vacancy check
//        - Else successful checkout after switching capsules[i] back to vacant.

        System.out.println("================");
        System.out.println("**Checking Out**");
        System.out.println("================");
        System.out.print("Please enter the room you're checking out from: ");
        int checkOutRoom = getPositiveInteger(scanner) -1;

        if (checkOutRoom < 0 || checkOutRoom >= capsules.length) {
            System.out.println("Invalid room number. Please choose a valid room number.");
            return;
        }

        if (!capsules[checkOutRoom].equals("Vacant")) {
            String temp = capsules[checkOutRoom];
            capsules[checkOutRoom] = "Vacant";
            System.out.println("Successfully checked " + temp + " out from room " + (checkOutRoom+1) + ".");
        } else {
            System.out.println("Cannot check out, the room is already vacant.");
        }
    }

    public static void displayOccupancy(String[] capsules, Scanner scanner) {
        System.out.println("========================");
        System.out.println("**Displaying Occupancy**");
        System.out.println("========================");
        if (capsules.length <= 11) {
            System.out.println("Room Occupancy:");
            for (int i = 0; i < capsules.length; i++) {
                System.out.println("Room " + (i + 1) + ": " + (capsules[i].equals("Vacant") ? "Vacant" : "Occupied by " + capsules[i]));
                //compares capsules[i] to "Vacant", option 1 returns "Vacant", option 2 returns Occupied by name of guest!
            }
        } else {
            System.out.print("Enter the room number: ");
            int roomNumber = getPositiveInteger(scanner) - 1; // Adjusting index

            if (roomNumber < 0 || roomNumber >= capsules.length) {
                System.out.println("Invalid room number. Please choose a valid room number.");
                return;
            }

            int startIndex = Math.max(0, roomNumber - 5); // Starting index for display
            int endIndex = Math.min(capsules.length - 1, roomNumber + 5); // Ending index for display

            System.out.println("Room Occupancy:");
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.println("Room " + (i + 1) + ": " + (capsules[i].equals("Vacant") ? "Vacant" : "Occupied by " + capsules[i]));
            }
        }

    }


    public static boolean confirmExit(Scanner scanner) {
        // Confirm exit method, that takes the input argument
        // Basic input validation to only Y or N, takes both capitalization and lowercase.
        // true if y, false if n.
        System.out.println("===================");
        System.out.println("**Confirming Exit**");
        System.out.println("===================");
        System.out.print("Are you sure you want to exit?(y/n): ");
        char input = scanner.next().toLowerCase().charAt(0);
        while (input != 'y' && input !='n' ) {
            System.out.println("Invalid input. Please enter 'y' or 'n'. ");
            System.out.print("Are you sure you want to exit?");
            input = scanner.next().toLowerCase().charAt(0);
        }

        if (input == 'y'){
            System.out.println("Thank you for using Hanoi Capsule Management System!!");
            return true;
        } else {
            return false;
        }

    }

    public static int getPositiveInteger(Scanner scanner) {
        int input = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input > 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive integer");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return input;
    }

}