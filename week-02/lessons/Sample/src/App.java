public class App {
    public static void main(String[] args) {

//        NationalForest one = new NationalForest();
//        one.name = "Allegheny";
//        one.location = "Pennsylvania";
//        one.acres = 513655;
//
//        NationalForest two = new NationalForest();
//        two.name = "Angeles";
//
//        NationalForest three = new NationalForest();
//        three.name = "Angelina";

        NationalForest one = new NationalForest("Allegheny", "Pennsylvania", 513655);
        NationalForest two = new NationalForest("Angeles", "California", 661565);
        NationalForest three = new NationalForest("Angelina", "Texas", 154140);
        NationalForest four = new NationalForest();

        String format = "name: %s, location: %s, acres: %s%n";

        System.out.printf(format, one.name, one.location, one.acres);
        System.out.printf(format, two.name, two.location, two.acres);
        System.out.printf(format, three.name, three.location, three.acres);
        System.out.printf(format, four.name, four.location, four.acres);
    }
}
