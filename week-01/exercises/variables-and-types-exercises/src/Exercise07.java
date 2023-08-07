public class Exercise07 {

    public static void main(String[] args) {
        // 1. Calculate the number of offices in a 23 story building
        // where each floor has 15 "rows" and 8 "columns" of offices.
        // 2. Use whatever approach you think is best.
        // 3. Print the result.
        int buildingHeight = 23;
        int rows = 15;
        int columns = 8;
        int totalOffices = buildingHeight * rows * columns;

        System.out.println("The number of offices in a building with " + buildingHeight +
                " stories where each floor has " + rows + " rows and " + columns + " columns of offices is: " +
                totalOffices);
    }
}
