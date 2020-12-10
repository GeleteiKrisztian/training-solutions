package ioreadstring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileManager {
    private Path path;
    private List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        this.path = Path.of(path);
    }

    public Path getMyFile() {
        return path;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void readFromFile() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (String item : lines) {
            String[] split = item.split(" ");
            humans.add(new Human(split[0],split[1]));
        }
    }

}
