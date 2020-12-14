package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeAsBytes(List<String> parts, Path file) {
        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (String item : parts) {
            if (!item.startsWith("_")) {
                os.write(item.getBytes());
                }
            }

        } catch (IOException ex) {
            throw new IllegalArgumentException("Can't write the file.",ex);

        }
    }

}
