package ioreadstring;

public class BankAccount {

    private String name;
    private String accountNumber;
    private long balance;

    public BankAccount(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance += balance;
    }

}
