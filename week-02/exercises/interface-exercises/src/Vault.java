public class Vault implements MoneyStorage{

    //fields
    private double balance;
    private String description;

    //constructors
    public Vault (double balance, String description) {
        this.balance = balance;
        this.description = description;
    }
    //methods

//    Rules:
//            - Deposits must be positive values.
//    - Cannot overdraw, but can return the remaining balance.
//    For example, if the balance is 45.0 and we withdraw(109.0)
//    the amount returned should be 45.0 and the balance should be 0.0 after the method call.

    @Override
    public double getBalance(){
        return balance;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean deposit(double amount){
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) {
            return 0;
        }

        double withdrawalAmount = Math.min(amount, balance); //whichever is smaller between amount, and balance.
        balance -= withdrawalAmount; //update the balance
        return withdrawalAmount;
    }
}
