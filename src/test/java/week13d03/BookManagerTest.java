package week13d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {

    private List<Book> books = List.of(new Book("John Doe", "Jackie", 200), new Book("Jack Doe", "Johnie", 280), new Book("Jane Doe", "Janie", 250));

    @Test
    void mostPagesAuthor() {
        assertEquals("Jack Doe", new BookManager(books).mostPagesWritten());
    }

}