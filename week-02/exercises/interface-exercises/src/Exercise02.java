public class Exercise02 {


    // 1. Create a method.
    // Name: printAll
    // Inputs: MoneyStorage[]
    // Output: void
    // Description: prints the details for each MoneyStorage in the array.

    public static void main(String[] args) {
        MoneyStorage[] storages = {
                new Wallet(3.25, "Red Wallet"),
                new Mortgage(320000, "1234-dfdf-8790-trtr"),
                // 2. Declare a third MoneyStorage here.
                new Wallet(50.75, "Blue Wallet")
        };

        System.out.printf("Before deposit: %n");
        printAll(storages);
        depositInAll(storages, 100.00);
        System.out.println();
        System.out.println("===============================================");

        // 3. Pass storages as an argument to printAll.

        // Sample Output
        // Red Wallet: 103.25
        // Mortgage #1234-dfdf-8790-trtr: -319900.0
        // [Some description]: [balance]
        System.out.printf("After deposit: %n");
        printAll(storages);
    }


    static void depositInAll(MoneyStorage[] storages, double amount) {
        for (MoneyStorage storage : storages) {
            storage.deposit(amount);
        }
    }

    public static void printAll(MoneyStorage[] storages){
        for (int i = 0; i < storages.length; i++) {
            System.out.printf("%s: %.2f%n", storages[i].getDescription(), storages[i].getBalance()); //.2f = floating number with 2 decimal places.
        }
    }

}
