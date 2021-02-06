package inheritancemethods;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

    public boolean transaction(long amount) {
        if (getBalance() + costOfTransaction(amount) >= amount) {
            return super.transaction(amount);
        }
        if (getBalance() + overdraftLimit >= amount + costOfTransaction(amount)) {
            overdraftLimit -= (amount + costOfTransaction(amount) - getBalance());
            balanceToZero();
            return true;
        }
        return false;
    }

}
