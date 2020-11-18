package algorithmscount;

public class Transaction {

private String accountNumber;
private TransactionType transactionType;
private int amount;

    public Transaction(String accountNumber, TransactionType transactionType, int amount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isCredit() {
        if (transactionType == TransactionType.CREDIT) {
            return true;
        }
        return false;
    }

    public boolean isDebit() {
        if (transactionType == TransactionType.DEBIT) {
            return true;
        }
        return false;
    }

}
