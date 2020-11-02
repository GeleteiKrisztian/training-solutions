package classsctructureintegrate;

public class BankAccount {

    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber,String owner,int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public void transfer(BankAccount transferAccount,int amount) {
        balance -= amount;
        transferAccount.deposit(amount);
    }

    public String getInfo() {
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }
}
