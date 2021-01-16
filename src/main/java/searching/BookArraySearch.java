package searching;

import java.util.*;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] getBookArray() {
        return bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (isNullOrEmpty(author) || isNullOrEmpty(title)) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        List<Book> books = new ArrayList<>(Arrays.asList(bookArray));
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        int index = Collections.binarySearch(books, new Book(author, title));
        if (index < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        } else {
            return books.get(index);
        }
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }
}
