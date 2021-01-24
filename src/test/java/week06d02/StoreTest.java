package week06d02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    List<Product> products = new ArrayList<>(Arrays.asList(new Product("Frozen", Categories.FROZEN, 250.0),
            new Product("Diary", Categories.DAIRY, 300.0), new Product("Baked", Categories.BAKEDGOODS, 400.0),
            new Product("AnotherFrozen", Categories.FROZEN, 450.0), new Product("Other", Categories.OTHER, 200.0)));

    @Test
    void getProductsByCategoryTest() {
        Store store = new Store(products);
        assertEquals(5, store.getProducts().size());
        assertEquals(4, store.getProductsByCategory().size());
    }

    @Test
    void getProductsByCategoryResultFirstItemTest() {
        Store store = new Store(products);
        assertEquals(2, store.getProductsByCategory().get(0).getQuantity());
    }

}