package algorithmsdecision;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> bankAccounts, int amount) {
        for (BankAccount item : bankAccounts) {
            if (item.getBalance() > amount) {
                return true;
            }
        }
        return false;
    }

}
