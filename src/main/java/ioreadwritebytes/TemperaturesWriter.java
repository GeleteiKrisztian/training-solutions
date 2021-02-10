package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temps, String path) {
        try {
            Files.write(Path.of(path), temps.getData());
        } catch (IOException ioe) {
            throw new IllegalArgumentException("", ioe);
        }
    }

}
