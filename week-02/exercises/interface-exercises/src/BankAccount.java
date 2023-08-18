public class BankAccount implements MoneyStorage{

    private double balance;
    private String accountNumber;


    public BankAccount(double Startingbalance, String accountNumber) {
        this.balance = Startingbalance;
        this.accountNumber = accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    @Override
    public String getDescription() {
        return String.format("Bank Account #: %s", accountNumber);
    }

    @Override
    public boolean deposit(double amount) {
       if(amount > 0){
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
        double withdrawalAmount = Math.min(amount, balance + 25.00);
        balance -= withdrawalAmount;
        return withdrawalAmount;
    }
}
