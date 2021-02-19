package lambdaprimitives;

import java.util.*;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getNumberOfProducts() {
        return products.stream().mapToInt(p -> p.getPiece()).sum();
    }

    public double getAveragePrice() {
        OptionalDouble opt = products.stream().mapToDouble(p -> p.getPrice()).average();
        if (opt.isPresent()) {
            return opt.getAsDouble();
        } else {
            return 0;
        }
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics iSumStat = products.stream().filter(price -> price.getPrice() >= minPrice).mapToInt(p -> p.getPiece()).summaryStatistics();
        if (iSumStat.getCount() == 0) {
            return "Nincs ilyen termék.";
        } else {
            return "Összesen " + iSumStat.getCount() + " féle termék, amelyekből minimum " + iSumStat.getMin() + " db, maximum " + iSumStat.getMax() + " db, összesen " + iSumStat.getSum() + " db van.";
        }
    }

}
