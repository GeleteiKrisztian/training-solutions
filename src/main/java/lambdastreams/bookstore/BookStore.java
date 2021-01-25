package lambdastreams.bookstore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public long getNumberOfBooks() {
        Stream<Book> bookStream = books.stream();
        return 0;
    }

    public Optional<Book> findNewestBook() {
        if (books.isEmpty()) {
            return Optional.empty();
        }
        Stream<Book> bookStream = books.stream();
        return bookStream.max(Comparator.naturalOrder());
    }

    public int getTotalValue() {
        Stream<Book> bookStream = books.stream();
        return 0;
    }

}
