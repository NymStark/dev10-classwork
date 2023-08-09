import java.util.Scanner;

public class KnockKnockJoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Knock, knock.");
        System.out.print("Who's there? ");
        String prompt = scanner.nextLine();

        switch (prompt.toLowerCase()) {
            case "lettuce":
                System.out.print("Lettuce who? ");
                System.out.println("Lettuce in, it's cold out here!");
                break;
            case "orange":
                System.out.println("Orange who? ");
                System.out.println("Orange you glad you didn't get a banana joke?");
                break;
            case "hawaii":
                System.out.println("Hawaii who? ");
                System.out.println("I'm good, Hawaii you?");
                break;
            case "java":
                System.out.println("Java who? ");
                System.out.println("Java good day coding!!");
                break;
            case "html":
                System.out.println("HTML  who? ");
                System.out.println("HTML-arious how bugs disappear when you're around!");
                break;
            case "git":
                System.out.println("Git who? ");
                System.out.println("Git outta here, I need some space to code!");
                break;
            case "css":
                System.out.println("CSS who? ");
                System.out.println("CSS your way out of this maze of divs and spans!");
                break;
            case "null":
                System.out.println("Null who? ");
                System.out.println("Null point exception - my jokes are a bit null sometimes!");

            default:
                System.out.println("I don't know you.");
        }
    }
}