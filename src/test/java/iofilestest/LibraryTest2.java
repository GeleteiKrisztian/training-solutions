package iofilestest;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest2 {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

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
        Path file = tempFolder.newFile("generatedBooks.txt").toPath();
        Library library = new Library();
        library.add(new Book("Jack Doe", "Title"), new Book("Jane Doe", "Title"), new Book("John Doe", "Title"));
        library.saveBooks(file);
        library.loadBooks(file);
        assertEquals(3,library.getBooks().size());
    }

}
