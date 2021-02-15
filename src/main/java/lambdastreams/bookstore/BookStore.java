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

    public int getNumberOfBooks() {
        Stream<Book> bookStream = books.stream();
        return bookStream.reduce(0, (b1, b2) -> b1 + b2.getPiece(), (b1, b2) -> b1 + b2);
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
        return bookStream.reduce(0, (iden, value) -> iden + value.getPrice() * value.getPiece(),(iden, value) -> iden + value);
    }

}
