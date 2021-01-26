package lambdaprimitives;

public class Product {

    private String name;
    private double price;
    private int piece;

    public Product(String name, double price, int piece) {
        this.name = name;
        this.price = price;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPiece() {
        return piece;
    }
}
