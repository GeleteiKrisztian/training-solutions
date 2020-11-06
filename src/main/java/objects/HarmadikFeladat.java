package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HarmadikFeladat {

    public static void main(String[] args) {

        System.out.println("3. Feladat");
        Book[] books = {new Book(), new Book(), new Book()};

        List<Book> booksList = new ArrayList<>(Arrays.asList(books[0], books[1], books[2]));
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(books[0]);
        listOfBooks.add(books[1]);
        listOfBooks.add(books[2]);
    }
}
