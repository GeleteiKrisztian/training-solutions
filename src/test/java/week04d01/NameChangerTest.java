package week04d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import week04d01.NameChanger;

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