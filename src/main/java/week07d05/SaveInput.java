package week07d05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    public void saveInp() {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = null;
        for (int i = 0; i < 3; i++) {
            System.out.println("Add meg az " + (i+1) + ". sort:");
            line = scanner.nextLine();
            lines.add(line);
        }
        System.out.println("Add meg az elérési utat:");
        String file = scanner.nextLine();

        try (BufferedWriter bos = new BufferedWriter(Files.newBufferedWriter(Path.of(file)))) {
            for (String item : lines) {
                bos.write(item + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't write the file.", ioe);
        }
    }

}
