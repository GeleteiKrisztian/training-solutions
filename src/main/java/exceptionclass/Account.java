package exceptionclass;

public class Account {

    private String accountNumber;
    private double balance;
    private double maxSubtract = 100000;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("AccountNumber can't be null");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String accountNumber, double balance, double maxSubtract) {
        this(accountNumber, balance);
        this.maxSubtract = maxSubtract;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        this.maxSubtract = maxSubtract;
    }

    public void subtract(double amount) {
        if (balance - amount < 0) {
            throw new InvalidBankOperationException(ErrorCode.LOW_BALANCE);
        }
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

}
