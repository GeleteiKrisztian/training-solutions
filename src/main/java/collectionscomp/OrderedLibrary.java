package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> ordByTitBooks = new ArrayList<>(libraryBooks);
        Collections.sort(ordByTitBooks);
        return ordByTitBooks;
    }

    public List<Book> orderedByAuthor() {
        List<Book> orderedByAuthorBooks = new ArrayList<>(libraryBooks);
        Collections.sort(orderedByAuthorBooks, new AuthorComparator());
        return orderedByAuthorBooks;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> orderedTitles = new ArrayList<>();
        for (Book item : libraryBooks) {
            orderedTitles.add(item.getTitle());
        }
        Collections.sort(orderedTitles, Collator.getInstance(locale));
        return orderedTitles;
    }

    public List<Book> getLibraryBooks() {
        return new ArrayList<>(libraryBooks);
    }
}
