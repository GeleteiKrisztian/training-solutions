package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> accounts = new ArrayList<>(bankAccounts);
        accounts.sort(Comparator.naturalOrder());
        return accounts;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> accounts = new ArrayList<>(bankAccounts);
        accounts.sort(Comparator.comparingDouble(BankAccount::getBalance)
        );
        return accounts;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> accounts = new ArrayList<>(bankAccounts);
        accounts.sort((account1, account2) -> Double.compare(account2.getBalance(), account1.getBalance()));
        return accounts;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));

        ordered.sort(
                Comparator.comparing(BankAccount::getNameOfOwner,
                        Comparator.nullsFirst(collator))
                        .thenComparing(BankAccount::getAccountNumber));
        return ordered;
    }
   // Comparator.naturalOrder(), Comparator.comparing(), Comparator.reversed(), Comparator.nullsFirst(), Comparator.thenComparing().
}
