package week14d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HachikoTest {

    @Test
    void countHachikoTest() {
        assertEquals(4, new Hachiko().countHachiko());
    }
}