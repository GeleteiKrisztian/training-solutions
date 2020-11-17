package algorithmssum;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction item : transactions) {
            if (item.getTransactionOperation() == TransactionOperation.CREDIT) {
                sum += item.getAmount();
            }
        }
        return sum;
    }

}
