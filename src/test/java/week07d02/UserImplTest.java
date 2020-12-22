package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserImplTest {

    @Test
    void userNameTest() {
        assertEquals("johndoe", new UserImpl("johndoe", "John", "Doe").getUserName());
    }

    @Test
    void firstNameTest() {
        assertEquals("John", new UserImpl("johndoe", "John", "Doe").getFirstName());
    }

    @Test
    void lastNameTest() {
        assertEquals("Doe", new UserImpl("johndoe", "John", "Doe").getLastName());
    }

    @Test
    void fullNameTest() {
        assertEquals("John Doe", new UserImpl("johndoe", "John", "Doe").getFullName());
    }

}
