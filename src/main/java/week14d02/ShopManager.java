package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShopManager {

    Map<String, List<Shopping>> map = new HashMap<>();

    public void readFile(BufferedReader reader) {
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                String[] id = parts[0].split("-");
                String shopperID = id[0];
                String shopID = id[1];
                String[] shopping = parts[1].split(",");
                List<Product> products = new ArrayList<>();
                for (String s : shopping) {
                    String product = s.substring(0, s.indexOf("("));
                    String price = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
                    products.add(new Product(product, Integer.parseInt(price)));
                }
                Shopping actual = new Shopping(shopID, products);
                if (!map.containsKey(shopperID)) {
                    map.put(shopperID, new ArrayList<>());
                }
                map.get(shopperID).add(actual);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public int getPriceById(String id) {
        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
            for (Shopping shopping : entry.getValue()) {
                if (shopping.getId().equals(id)) {
                    return shopping.sumPrice();
                }
            }
        }
        throw new IllegalArgumentException("No data");
    }

    public int getPriceByShopper(String shopperId) {
        List<Shopping> shopping = map.get(shopperId);
        return shopping.stream().reduce(0, (i, s) -> i + s.sumPrice(), Integer::sum);
    }

    public List<Product> sortedBy(String name, String shopId, Comparator<Product> comp) {
//        List<Product> products = map.get(name).stream().filter(s -> s.getId().equals(shopId)).map(s->s.getProducts());
        List<Product> result;
        for (Shopping shopping : map.get(name)) {
            if (shopping.getId().equals(shopId)) {
                result = new ArrayList<>(shopping.getProducts());
                result.sort(comp);
                return result;
            }
        }

        throw new IllegalArgumentException("No data");
    }

    public int numberBought(String name) {
        int sum = 0;
        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
            for (Shopping shopping : entry.getValue()) {
                for (Product product : shopping.getProducts()) {
                    if (product.getName().equals(name)) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public Map<String, Integer> statistics() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, List<Shopping>> entry : map.entrySet()) {
            for (Shopping shopping : entry.getValue()) {
                for (Product product : shopping.getProducts()) {
                    result.put(product.getName(), numberBought(product.getName()));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ShopManager test = new ShopManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(ShopManager.class.getResourceAsStream("/shoppinglist2.txt")));
        test.readFile(reader);
        System.out.println(test.getPriceByShopper("BK123"));
        System.out.println(test.getPriceById("1211"));
        System.out.println(test.sortedBy("BK123", "1211", Comparator.comparing(Product::getName)));
        System.out.println(test.sortedBy("BK123", "1211", Comparator.comparing(Product::getPrice)));
        System.out.println(test.numberBought("beer"));
        Map<String, Integer> map = test.statistics();
        System.out.println(map.get("beer"));
    }

}