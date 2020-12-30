package week03d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationTest {

    @Test
    void throwsExeptionTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Operation(""));
        assertEquals("Argument is null or empty.", ex.getMessage());
    }

    @Test
    void resultTest() {
        assertEquals(39, new Operation("13+26").getResult());
    }

}
