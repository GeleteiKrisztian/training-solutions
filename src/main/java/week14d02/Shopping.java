package week14d02;

import java.util.ArrayList;
import java.util.List;

public class Shopping {

    private String id;
    private List<Product> products;

    public Shopping(String id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public int sumPrice() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}