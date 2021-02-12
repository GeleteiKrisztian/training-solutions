package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheeseManagerTest {

    @TempDir
    Path folder;

    @Test
    void saveTest() throws IOException {
        Path file = folder.resolve("cheese.txt");
        CheeseManager cheeseManager = new CheeseManager();
        cheeseManager.saveToFile(List.of(new Cheese("1",2.14), new Cheese("2", 1.1)), file);
        List<String> cheeses = Files.readAllLines(file);
        assertEquals(2, cheeses.size());


    }

    @Test
    void loadTest() throws IOException {
        Path file = folder.resolve("sajt.txt");
        CheeseManager cheeseManager = new CheeseManager();
        cheeseManager.saveToFile(List.of(new Cheese("1",2.14), new Cheese("2", 1.1)), folder.resolve(file));
        Cheese cheese = cheeseManager.findCheese("1", folder.resolve(file));
        assertEquals("1", cheese.getName());
        assertEquals(2.14, cheese.getLactoseAmount());
    }

    @Test
    void throwsIfNotFound() {
        Path file = folder.resolve("sajt.txt");
        CheeseManager cheeseManager = new CheeseManager();
        cheeseManager.saveToFile(List.of(new Cheese("1",2.14), new Cheese("2", 1.1)), folder.resolve(file));
        assertThrows(IllegalArgumentException.class, () -> cheeseManager.findCheese("4", folder.resolve(file)));
    }

}
