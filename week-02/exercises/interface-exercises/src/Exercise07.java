import java.util.Scanner;

public class Exercise07 {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        MoneyStorage storage = getStorage();
        String input;
        do {
            print(storage);

            System.out.println("Choose an action:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Select [1-3]:");

            input = console.nextLine();

            if (input.equals("1")) {
                makeDeposit(storage);
            } else if (input.equals("2")) {
                makeWithdrawal(storage);
            }

        } while (!input.equals("3"));

        System.out.println("Goodbye.");
    }

    static MoneyStorage getStorage() {

        System.out.println("Choose a place to store your money:");
        System.out.println("1. Wallet");
        System.out.println("2. Mortgage");
        System.out.println("3. Vault");
        System.out.println("4. Bank Account");

        String input;
        do {
            System.out.print("Select [1-4]:");
            input = console.nextLine();
        } while (!(input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '4'));

        // 1. Add a switch statement to handle options 1 - 4.
        // 2. For each option, create a method that returns a MoneyStorage of the appropriate type:
        // 1 == Wallet, 2 == Mortgage, 3 == Vault, 4 == Bank Account
        // Prompt the user for data. Data should be specific to the type:
        // - a starting balance
        // - description for a Wallet
        // - accountNumber for Mortgage and BankAccount
        // - for Vault?

        // 3. Return the Wallet, Mortgage, Vault, or Bank Account instead of null.
        MoneyStorage storage = null;
        switch (input) {
            case "1":
                storage = createWallet();
                break;
            case "2":
                storage = createMortgage();
                break;
            case "3":
                storage = createVault();
                break;
            case "4":
                storage = createBankAccount();
                break;
        }

        return storage;
    }

    static void print(MoneyStorage storage) {
        System.out.println();
        System.out.println(storage.getDescription());
        System.out.println("=".repeat(storage.getDescription().length()));
        System.out.printf("Current balance: $%.2f%n", storage.getBalance());
        System.out.println();
    }

    static void makeDeposit(MoneyStorage storage) {
        System.out.print("Amount to deposit:");
        double amt = Double.parseDouble(console.nextLine());
        storage.deposit(amt);
    }

    static void makeWithdrawal(MoneyStorage storage) {
        System.out.print("Amount to withdraw:");
        double amt = Double.parseDouble(console.nextLine());
        double withdrawn = storage.withdraw(amt);
        System.out.printf("Withdrawn: $%.2f%n", withdrawn);
    }

    //creating new instances.
    static Wallet createWallet() {
        System.out.print("Enter starting balance for Wallet:");
        double balance = Double.parseDouble(console.nextLine());
        System.out.print("Enter description for Wallet:");
        String description = console.nextLine();
        return new Wallet(balance, description);
    }
    static Mortgage createMortgage() {
        System.out.print("Enter starting balance for Mortgage:");
        double balance = Double.parseDouble(console.nextLine());
        System.out.print("Enter account number for Mortgage:");
        String accountNumber = console.nextLine();
        return new Mortgage(balance, accountNumber);
    }

    // Method for creating a new Vault instance based on user input
    static Vault createVault() {
        System.out.print("Enter starting balance for Vault:");
        double balance = Double.parseDouble(console.nextLine());
        System.out.print("Enter description for Vault:");
        String description = console.nextLine();
        return new Vault(balance, description);
    }

    // Method for creating a new Bank Account instance based on user input
    static BankAccount createBankAccount() {
        System.out.print("Enter starting balance for Bank Account:");
        double balance = Double.parseDouble(console.nextLine());
        System.out.print("Enter account number for Bank Account:");
        String accountNumber = console.nextLine();
        return new BankAccount(balance, accountNumber);
    }
}
