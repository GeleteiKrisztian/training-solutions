package ioreadwritestring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String pathStr) {
        Path path = Path.of(pathStr);
        try {
            Files.write(path, temperatures.getData());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
