package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeparatedSumTest {

    @Test
    void argIsNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> { new SeparatedSum().sumString(null);
        });
        assertEquals("Argument is null or empty!", ex.getMessage());
    }

}
