package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = new HashSet<>(libraryBooks);
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> it = libraryBooks.iterator();
        while (it.hasNext()) {
            Book book = it.next();
         if (book.getRegNumber() == regNumber) {
             return book;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
            Iterator<Book> it = libraryBooks.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book.getRegNumber() == regNumber) {
                it.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> books = new HashSet<>();
        Iterator<Book> it = libraryBooks.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book.getAuthor().equals(author)) {
               books.add(book);
            }
        }
        if (books.size() > 0) {
            return books;
        } else {
            throw new MissingBookException("No books found by " + author);
        }
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
