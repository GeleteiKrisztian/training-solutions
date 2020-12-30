package week02d03;

public class Product {

    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p) {
        int difference = this.code.length() - p.code.length();
        boolean lenghtGood = difference >= -1 && difference <= 1;
        boolean equal = this.name ==p.getName();
        return equal && lenghtGood;
    }

    public static void main(String[] args) {
        Product product1 = new Product("Phone","12345");
        Product product2 = new Product("Phone","123456");
        Product product3 = new Product("Monitor","123456789");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product1.areTheyEqual(product3));
    }
}
