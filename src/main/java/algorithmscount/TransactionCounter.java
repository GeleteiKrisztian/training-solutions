package algorithmscount;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions,int amount) {
        int counter = 0;
        for (Transaction item : transactions) {
            if (item.getAmount() < amount) {
                counter++;
            }
        }
        return counter;
    }

}
