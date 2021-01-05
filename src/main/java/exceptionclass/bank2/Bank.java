package exceptionclass.bank2;


import exceptionclass.bank.ErrorCode;

import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("List is null");
        }
        this.accounts = accounts;
    }

    public void payment(String account, double amount) {
        for (Account item : accounts) {
            if (item.getAccountNumber().equals(account)) {
                item.subtract(amount);
                return;
            }
        }
        throw new InvalidAccountNumberBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }

    public void deposit(String account, double amount) {
        for (Account item : accounts) {
            if (item.getAccountNumber().equals(account)) {
                item.deposit(amount);
                return;
            }
        }
        throw new InvalidAccountNumberBankOperationException(ErrorCode.INVALID_ACCOUNTNUMBER);
    }

}
