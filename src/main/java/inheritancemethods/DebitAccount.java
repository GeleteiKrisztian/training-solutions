package inheritancemethods;

public class DebitAccount {

    private String accountNumber;
    private long balance;

    private final double COST = 3.0;
    private final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public final long costOfTransaction(long amount) {
       double cost = amount * (COST / 100);
       if (cost < MIN_COST){
           cost = MIN_COST;
       }
       return (int) cost;
    }

    public boolean transaction(long amount) {
        long transAmount = costOfTransaction(amount) + amount;
        if (transAmount <= balance) {
            balance -= transAmount;
            return true;
        }
        return false;

    }

    public void balanceToZero() {
        balance = 0;
    }

}
