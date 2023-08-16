import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // 1. Add an empty constructor to Musician.
        // 2. Uncomment the code below and make sure it runs.

        Musician m = new Musician();
        System.out.print("Musician name:");
        m.setName(console.nextLine());
        System.out.print("Musician rating:");
        int rating = Integer.parseInt(console.nextLine());
        m.setRating(rating);
        System.out.printf("%s: %s%n", m.getName(), m.getRating());

        // 3. Add a loop. The exercise should ask the user for musicians and print
        // them out until the user types "end".

        while (true) {
            System.out.print("Enter musician's name (or 'end') to stop: ");
            String musicianName = console.nextLine();
            if (musicianName.equalsIgnoreCase("end")){
                break;
            }
            System.out.print("Enter musician rating: ");
            int musicianRating = Integer.parseInt(console.nextLine());
            Musician musician = new Musician();
            musician.setName(musicianName);
            musician.setRating(musicianRating);

            System.out.printf("The artist %s, has rating: %s%n", musician.getName(), musician.getRating());

        }
    }
}
