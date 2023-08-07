public class Exercise15 {

    public static void main(String[] args) {

        int value = 24;

        boolean inRange = (value >= 10 && value <= 20) || (value >=110 && value <= 120);

        System.out.println("Value: " + value);
        System.out.println("Is in Range: " + inRange);

        value = 9;
        inRange = (value >= 10 && value <= 20) || (value >=110 && value <= 120);
        System.out.println("Value: " + value);
        System.out.println("Is in Range: " + inRange);

        value = 12;
        inRange = (value >= 10 && value <= 20) || (value >=110 && value <= 120);
        System.out.println("Value: " + value);
        System.out.println("Is in Range: " + inRange);

        value = 115;
        inRange = (value >= 10 && value <= 20) || (value >=110 && value <= 120);
        System.out.println("Value: " + value);
        System.out.println("Is in Range: " + inRange);

        value = 280;
        inRange = (value >= 10 && value <= 20) || (value >=110 && value <= 120);
        System.out.println("Value: " + value);
        System.out.println("Is in Range: " + inRange);
    }
}