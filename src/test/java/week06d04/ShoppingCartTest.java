package week06d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    void addItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Alma", 2);
        shoppingCart.addItem("Körte", 3);
        shoppingCart.addItem("Alma", 3);
        assertEquals(2, shoppingCart.getItems().size());
    }

    @Test
    void searchItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Alma", 2);
        shoppingCart.addItem("Körte", 3);
        shoppingCart.addItem("Alma", 3);
        assertEquals(5, shoppingCart.getItem("Alma"));
    }

    @Test
    void searchNotExistingItemTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem("Alma", 2);
        shoppingCart.addItem("Körte", 3);
        shoppingCart.addItem("Alma", 3);
        assertEquals(0, shoppingCart.getItem("Narancs"));
    }

}
