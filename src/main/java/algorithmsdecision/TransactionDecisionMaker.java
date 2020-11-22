package algorithmsdecision;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime,LocalDateTime endTime,int amount) {
        boolean contains = false;
        int i = 0;
        while (i < transactions.size() && !contains) {
            boolean isInDateTimeinterval = startTime.isBefore(transactions.get(i).getDateOfTransaction()) && endTime.isAfter(transactions.get(i).getDateOfTransaction());
            if (transactions.get(i).isDebit() && isInDateTimeinterval && transactions.get(i).getAmount() > amount) {
                contains = true;
                return true;
            }
            i++;
        }
        return false;
    }
}
