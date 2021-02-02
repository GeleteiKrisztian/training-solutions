package week13d03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookManager {

    List<Book> books;

    public BookManager(List<Book> books) {
        this.books = books;
    }

    public String mostPagesWritten() {
        List<Book> bookList = new ArrayList<>(books);
        bookList.sort(Comparator.comparing(Book::getNumberOfPages).reversed());
        return bookList.get(0).getAuthor();
    }

}
