package algorithmscount;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int amount) {
        int counter = 0;
        for (BankAccount item : bankAccounts) {
            if (item.getBalance() > amount) {
                ++counter;
            }
        }
        return counter;
    }

}
