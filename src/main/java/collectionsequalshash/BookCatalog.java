package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        for (Book item : books) {
            if (item.getTitle().equals(title) && item.getAuthor().equals(author)) {
                return item;
            }
        }
        return null;
    }

    public Book findBook(List<Book> books, Book book) {
        for (Book item : books) {
            if (item.equals(book)) {
                return item;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> booksSet = new HashSet<>();
        for (Book item : books) {
            booksSet.add(item);
        }
        return booksSet;
    }

}
