package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary() {
        List<Book> reverseBooks = new ArrayList<>(library);
        Collections.reverse(reverseBooks);
        return reverseBooks;
    }

    public Book getFirstBook() {
        return library.get(0);
    }

    public Book getLastBook() {
        return library.get(library.size()-1);
    }

}
