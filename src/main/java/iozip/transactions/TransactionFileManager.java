package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path path, List<Transaction> transactions) {
        try(ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Transaction item : transactions) {
                String file = Long.toString(item.getId());
                zos.putNextEntry(new ZipEntry(file));
                zos.write((item.getTime().toString() + "\n").getBytes());
                zos.write((item.getAccount() + "\n").getBytes());
                zos.write(Double.toString(item.getAmount()).getBytes());
                zos.closeEntry();
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("", ioe);
        }
    }
}
