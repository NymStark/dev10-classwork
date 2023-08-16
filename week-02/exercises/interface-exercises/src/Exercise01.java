public class Exercise01 {

    /*
    Open the following types and read their comments.
    - MoneyStorage (interface)
    - Wallet (class)
    - Mortgage (class)
     */

    public static void main(String[] args) {
        Wallet wallet = new Wallet(0.0, "Brown Wallet");
        wallet.deposit(5.55);
        print(wallet);

        Mortgage mortgage = new Mortgage(250000.0, "abcd-1234-hdre-9898");
        print(mortgage);

        // 1. Declare a third MoneyStore variable here, either Wallet or Mortgage.
        // 2. Pass it to the `print` method.

        Wallet johnsWallet = new Wallet(100.0, "John's Wallet");
        print(johnsWallet);

        Mortgage johnsMortgage = new Mortgage(75000.75, "12001");
        print(johnsMortgage);
    }

    static void print(MoneyStorage storage) {
        System.out.println(storage.getDescription());
        System.out.printf("Current balance: $%.2f%n", storage.getBalance());
    }
}
