package ioreadstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accounts = new ArrayList<>();

    public List<BankAccount> getAccountList() {
        return new ArrayList<>(accounts);
    }

    public void uploadListFromFile(String path) {
        Path file = Path.of(path);
        List<String> bankAccountsLines;
        try {
            bankAccountsLines = Files.readAllLines(file);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("", ioe);
        }

        for (String item : bankAccountsLines) {
            String[] split = item.split(";");
            accounts.add(new BankAccount(split[0], split[1], Long.parseLong(split[2])));
        }
    }

    public void makeTransactions(String path) {
        Path file = Path.of(path);
        List<String> transLines;
        try {
            transLines = Files.readAllLines(file);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("", ioe);
        }

        for (String item : transLines) {
            String[] split = item.split(";");
            for (BankAccount item2 : accounts) {
                if (split[0].equals(item2.getAccountNumber())) {
                    item2.setBalance(Long.parseLong(split[1]));
                }
            }
        }
    }

}
