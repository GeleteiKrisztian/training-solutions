package week05d04;

import org.junit.jupiter.api.Test;
import week05d03.User;
import week05d03.UserValidator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    List<User> users = new ArrayList<>();


    @Test
    void listUsersContainsNull() throws IllegalArgumentException {
        users.add(new User(null,22));
            Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(users));
            assertEquals("Argument null or empty!", ex.getMessage());
        }

         @Test
         void listUsersContainsWhiteSpacesAndAlsoEmpty() throws IllegalArgumentException {
        users.add(new User("\n\t\r ",22));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(users));
        assertEquals("Argument null or empty!", ex.getMessage());
    }

        @Test
        void listUsersContainsNegativeAge() throws IllegalArgumentException {
        users.add(new User("John Doe", -1));
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(users));
        assertEquals("Invalid argument(s)!", ex.getMessage());
        }

        @Test
        void listUsersContainsGreaterThan120Age() throws IllegalArgumentException {
            users.add(new User("John Doe", 121));
            Exception ex = assertThrows(IllegalArgumentException.class, () -> new UserValidator().validate(users));
            assertEquals("Invalid argument(s)!", ex.getMessage());
        }

    @Test
    void listUsersIsValid() throws IllegalArgumentException {
        users.add(new User("John Doe", 22));
        assertTrue(new UserValidator().validate(users));
    }

}

