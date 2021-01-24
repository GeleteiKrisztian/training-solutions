package week06d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {

    private List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Categories> getProductsByCategory() {
        List<Categories> categories = new ArrayList<>(Arrays.asList(Categories.values()));
        for (Product item : products) {
            categories.get(item.getCategories().ordinal()).incQuantity();
        }
        return categories;
    }

}
