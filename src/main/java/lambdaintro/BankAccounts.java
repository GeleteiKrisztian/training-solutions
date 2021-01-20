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
        accounts.sort((account1, account2) -> account1.getAccountNumber().compareTo(account2.getAccountNumber()));
        return accounts;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> accounts = new ArrayList<>(bankAccounts);
        accounts.sort((account1, account2) ->
            Double.compare(account2.getBalance(), account1.getBalance())
        );
        return accounts;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> accounts = new ArrayList<>(bankAccounts);
        accounts.sort((account1, account2) -> {
            if(account1.getBalance() < account2.getBalance()) {
                return 1;
            } else if (account1.getBalance() > account2.getBalance()) {
                return -1;
            } else {
                return 0;
            }
        });
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
