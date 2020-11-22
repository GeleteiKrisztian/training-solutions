package algorithmsdecision;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions,List<BankAccount> accounts) {
        for(Transaction item : transactions) {
            for (BankAccount bankAccount : accounts) {
                if (item.getAccountNumber().equals(bankAccount.getAccountNumber())) {
                    if (item.isDebit()) {
                        bankAccount.withdraw(item.getAmount());
                        item.setStatus(Status.SUCCEEDED);
                    }
                    if (item.isCredit()) {
                        bankAccount.deposit(item.getAmount());
                        item.setStatus(Status.SUCCEEDED);
                    }

                }
                item.setStatus(Status.PENDING);
            }
        }
    }

}
