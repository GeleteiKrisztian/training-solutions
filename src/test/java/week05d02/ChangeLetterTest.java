package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChangeLetterTest {

    @Test
    void argIsNull() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new ChangeLetter().changeVowels(null);
        });
        assertEquals("Argument is null or empty!", ex.getMessage());
    }

    @Test
    void argIsEmpty() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new ChangeLetter().changeVowels("\t\n\r");
        });
        assertEquals("Argument is null or empty!", ex.getMessage());
    }

    @Test
    void argIsGood() {
        assertEquals("*lm*f*", new ChangeLetter().changeVowels("almafa"));
    }

}
