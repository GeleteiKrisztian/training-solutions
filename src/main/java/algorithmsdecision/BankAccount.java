package algorithmsdecision;

public class BankAccount {

    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean deposit(int amount) {
        int calculatedAmount = balance += amount;
        setBalance(calculatedAmount);
        return true;
    }

    public boolean withdraw(int amount) {
        int calculatedAmount = balance - amount;
            if (calculatedAmount >= 0) {
            setBalance(calculatedAmount);
            return true;
            }
            return false;
    }

}
