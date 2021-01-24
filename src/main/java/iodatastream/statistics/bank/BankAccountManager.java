package iodatastream.statistics.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path pathPar) {
        Path path = pathPar.resolve(account.getAccountNumber() + ".dat");
            try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
                dos.writeUTF(account.getAccountNumber());
                dos.writeUTF(account.getOwner());
                dos.writeDouble(account.getBalance());
            } catch (IOException ioe) {
                throw new IllegalStateException("", ioe);
            }
        }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream inputStream = new DataInputStream(new BufferedInputStream(is))) {
            String accNum = inputStream.readUTF();
            String own = inputStream.readUTF();
            double bal = inputStream.readDouble();
            return new BankAccount(accNum, own, bal);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

}
