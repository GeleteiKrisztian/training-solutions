package attributes.book;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("Gatsby");
        System.out.println(book.getTitle());
        book.setTitle("Great Gatsby");
        System.out.println(book.getTitle());
    }
}
