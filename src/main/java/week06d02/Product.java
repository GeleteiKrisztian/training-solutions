package week06d02;

public class Product {

    private String name;
    private Categories categories;
    private double price;

    public Product(String name, Categories categories, double price) {
        this.name = name;
        this.categories = categories;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Categories getCategories() {
        return categories;
    }

    public double getPrice() {
        return price;
    }
}
