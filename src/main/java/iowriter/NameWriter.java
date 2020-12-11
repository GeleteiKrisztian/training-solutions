package iowriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private Path file;

    public NameWriter(Path file) {
        this.file = file;
    }

    public void addAndWrite(String line) {
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            writer.write(line + "\n");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
