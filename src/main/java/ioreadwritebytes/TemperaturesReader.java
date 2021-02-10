package ioreadwritebytes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String path) {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(path));
            return new Temperatures(bytes);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

}
