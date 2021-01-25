package week07d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingListTest {

    @Test
    void sumTest() {
        assertEquals(210, new ShoppingList().calculateSum("src/main/resources/shoppinglist.txt"));
    }

}
