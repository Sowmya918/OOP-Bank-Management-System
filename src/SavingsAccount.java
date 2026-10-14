public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accNum, String name, double balance, double interestRate) {
        super(accNum, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= 100.0) {
            setBalance(getBalance() - amount);
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Denied: Savings accounts must maintain a $100 balance.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("[Savings Account] No: " + getAccountNumber()
                + " | Owner: " + getHolderName()
                + " | Balance: $" + getBalance());
    }
}