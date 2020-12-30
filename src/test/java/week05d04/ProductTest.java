package week05d04;

import org.junit.jupiter.api.Test;
import week05d04.Currency;
import week05d04.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    void hufToUsd() {
        assertEquals(2,new Product(600, Currency.HUF).convertPrice(Currency.USD));
    }

    @Test
    void usdToHuf() {
        assertEquals(300,new Product(1,Currency.USD).convertPrice(Currency.HUF));
    }
}
