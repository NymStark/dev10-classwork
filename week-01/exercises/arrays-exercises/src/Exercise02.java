public class Exercise02 {

    public static void main(String[] args) {

        String[] tenFavoriteFoods = new String[10]; // space for 10 favorite foods


        tenFavoriteFoods[0] = "Rice";
        tenFavoriteFoods[1] = "Ramen";
        tenFavoriteFoods[2] = "Adobo";
        tenFavoriteFoods[3] = "Stirfry";
        tenFavoriteFoods[4] = "Burger";
        tenFavoriteFoods[5] = "Pizza";
        tenFavoriteFoods[6] = "Pasta";
        tenFavoriteFoods[7] = "Chips";
        tenFavoriteFoods[8] = "Yogurt";
        tenFavoriteFoods[9] = "Ice cream";
        tenFavoriteFoods[10] = "Bread";


        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[6]);

        // 1. Set your 10 favorite foods. (It's okay to replace squid ink.)
        // 2. Print your top, 6th, and last favorite from tenFavoriteFoods.
        System.out.println("My most favorite food is: " + tenFavoriteFoods[0]);
        System.out.println("My 6th favorite food is: " + tenFavoriteFoods[5]);
        System.out.println("My 10th favorite food is: " + tenFavoriteFoods[9]);
    }
}
