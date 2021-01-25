package week07d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShoppingList {

    public long calculateSum(String file) {
        long sum = 0;
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                int piece = Integer.parseInt(split[1]);
                int price = Integer.parseInt(split[2]);
                sum += piece * price;
            }
            return sum;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read the file.", ioe);
        }
    }

}
