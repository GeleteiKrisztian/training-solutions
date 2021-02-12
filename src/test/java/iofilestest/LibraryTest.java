package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    @TempDir
    Path file;

    @Test
    void addMethodTest() {
        Library library = new Library();
        library.add(new Book("Jack Doe", "Title"), new Book("Jack Doe", "Title"));
        assertEquals("Jack Doe", library.getBooks().get(0).getAuthor());
    }

    @Test
    void addMethodFilterTest() {
        Library library = new Library();
        library.add(new Book("Jack Doe", "Title"), new Book("Jack Doe", "Title"));
        assertEquals(1, library.getBooks().size());
    }

    @Test
    void loadTest() {
        Library library = new Library();
        library.loadBooks(Path.of("books.txt"));
        assertEquals(2, library.getBooks().size());
    }

    @Test
    void saveTest() throws IOException {
        Path path = file.resolve("generatedBooks.txt");
        Library library = new Library();
        library.add(new Book("Jack Doe", "Title"), new Book("Jane Doe", "Title"), new Book("John Doe", "Title"));
        library.saveBooks(path);
        library.loadBooks(path);
        assertEquals(3,library.getBooks().size());
    }

}
