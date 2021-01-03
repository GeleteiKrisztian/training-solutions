package iozip.transactions;

import java.time.LocalDateTime;

public class Transaction {

    private final long ID;
    private final LocalDateTime dateTime;
    private final String account;
    private final double amount;

    public Transaction(long ID, LocalDateTime dateTime, String account, double amount) {
        this.ID = ID;
        this.dateTime = dateTime;
        this.account = account;
        this.amount = amount;
    }

    public long getId() {
        return ID;
    }

    public LocalDateTime getTime() {
        return dateTime;
    }

    public String getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

}
