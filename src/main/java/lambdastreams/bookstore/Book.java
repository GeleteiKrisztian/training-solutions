package lambdastreams.bookstore;

public class Book implements Comparable<Book> {

    private String title;
    private int yearOfPublish;
    private int price;
    private int piece;

    public Book(String title, int yearOfPublish, int price, int piece) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.piece = piece;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getPiece() {
        return piece;
    }

    @Override
    public int compareTo(Book o) {
        return yearOfPublish - o.yearOfPublish;
    }

}
