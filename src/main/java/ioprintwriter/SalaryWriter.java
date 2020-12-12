package ioprintwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String item : names) {
                writer.print(item);
                writer.print(": ");
                if (item.toLowerCase().startsWith("dr")) {
                    writer.println(Titles.DR.getSalary());
                } else if (item.toLowerCase().startsWith("mr")) {
                    writer.println(Titles.MR.getSalary());
                } else {
                    writer.println(Titles.OTHER.getSalary());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
