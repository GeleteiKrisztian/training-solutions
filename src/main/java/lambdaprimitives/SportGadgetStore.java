package lambdaprimitives;

import java.util.ArrayList;
import java.util.List;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getNumberOfProducts() {
        return products.stream().map(Product::getPiece).reduce(0, (iden, i) -> iden + i);
    }

    public double getAveragePrice() {
        return products.stream().mapToDouble(Product::getPrice).average().getAsDouble();
    }

    public String getExpensiveProductStatistics(double minPrice) {
        return "";
    }

}
