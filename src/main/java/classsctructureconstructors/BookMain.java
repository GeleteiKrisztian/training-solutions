package classsctructureconstructors;

public class BookMain {

    public static void main(String[] args) {
        Book book = new Book("G.K.","Ez itt egy cím");
        book.register("123456789");

        System.out.println("A könyv szerzője: " + book.getAuthor() + " A címe: " + book.getTitle());
        System.out.println("A reg. száma: " + book.getRegNumber());
    }

}
