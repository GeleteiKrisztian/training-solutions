package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    void createTest() {
        assertEquals("PET_BOTTLE",Bottle.of(BottleType.PET_BOTTLE).getType().toString());
        assertEquals(0 ,Bottle.of(BottleType.PET_BOTTLE).getFilledUntil());
    }

    @Test
    void fillGoodAmountTest() {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        bottle.fill(2);
        assertEquals(2 , bottle.getFilledUntil());
    }

    @Test
    void fillTooMuchTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> Bottle.of(BottleType.GLASS_BOTTLE).fill(3));
        assertEquals("Can't fill the bottle.", ex.getMessage());
    }

}
