import java.util.Scanner;


        public class Exercise10 {

            public static void main(String[] args) {
                // USPS
                // Below is an abbreviated version of the US Postal Service retail parcel rates:
        /*
        Lbs | Zones 1&2 | Zone 3
        ===============
        1      $7.50      $7.85
        2       8.25       8.70
        3       8.70       9.70
        4       9.20      10.55
        5      10.20      11.30
        */

                // 1. Collect the parcel lbs and zone (1, 2, or 3) from the user.
                // 2. Add `if`/`else if`/`else` logic to cover all rates.
                // Use whatever strategy you think is best. You can create compound conditions or nest if/else statements.
                // If a lbs/zone combo does not exist, print a warning message for the user.
            Scanner console = new Scanner(System.in);
            System.out.print("Enter the parcel weight in pounds: ");
            double weight = console.nextDouble();
            System.out.print("Enter the zone (1, 2, or 3): ");
            int zone = console.nextInt();
            double rate;

                if (weight >= 0 && weight < 1) {
                    if (zone == 1 || zone == 2) {
                        rate = 7.50;
                    } else if (zone == 3) {
                        rate = 7.85;
                    } else {
                        System.out.println("Invalid zone entered.");
                        return;
                    }
                } else if (weight >= 1 && weight < 2) {
                    if (zone == 1 || zone == 2) {
                        rate = 8.25;
                    } else if (zone == 3) {
                        rate = 8.70;
                    } else {
                        System.out.println("Invalid zone entered.");
                        return;
                    }
                } else if (weight >= 2 && weight < 3) {
                    if (zone == 1 || zone == 2) {
                        rate = 8.70;
                    } else if (zone == 3) {
                        rate = 9.70;
                    } else {
                        System.out.println("Invalid zone entered.");
                        return;
                    }
                } else if (weight >= 3 && weight < 4) {
                    if (zone == 1 || zone == 2) {
                        rate = 9.20;
                    } else if (zone == 3) {
                        rate = 10.55;
                    } else {
                        System.out.println("Invalid zone entered.");
                        return;
                    }
                } else if (weight >= 4 && weight <= 5) {
                    if (zone == 1 || zone == 2) {
                        rate = 10.20;
                    } else if (zone == 3) {
                        rate = 11.30;
                    } else {
                        System.out.println("Invalid zone entered.");
                        return;
                    }
                } else {
                    System.out.println("Invalid weight entered.");
                    return;
                }

                System.out.println("The shipping rate is: $" + rate);
            }
        }


