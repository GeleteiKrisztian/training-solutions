package week04d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stringconcat.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameChangerTest {

    @Test
    void changeFirstNameTest() {
        NameChanger nc = new NameChanger("John Doe");
        nc.changeFirstName("Jack");
        assertEquals("Jack Doe", nc.getFullName());
    }

    @Test
    void constuctorThrowsTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameChanger(null);
        });
    }

    @Test
    void changeWithNullThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameChanger("John Doe").changeFirstName(null);
        });
    }
}