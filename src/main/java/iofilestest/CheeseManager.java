package iofilestest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class CheeseManager {

    public void saveToFile(List<Cheese> cheeses, Path file) {
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (Cheese item : cheeses) {
                String concat = item.getName() + ":" + item.getLactoseAmount() + "\n";
                outputStream.write(concat.getBytes());
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't write the file.", ioe);
        }
    }

    public Cheese findCheese(String word, Path file) {
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))) {
            byte[] bytes = inputStream.readAllBytes();
            String str = new String(bytes, StandardCharsets.UTF_8);
            Scanner scanner = new Scanner(str).useDelimiter(" ");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] split = line.split(":");
                if (split[0].equals(word)) {
                    return new Cheese(split[0], Double.parseDouble(split[1]));
                }
            }
            throw new IllegalArgumentException("Can't find this cheese.");
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't write the file.", ioe);
        }
    }

}
