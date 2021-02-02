package week12d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClientsTest {

    public Map<String, Client> clients;
    {
        clients = new HashMap<>();
        clients.put("1234", new Client("John Doe", "1234"));
        clients.put("4321", new Client("Jack Doe", "4321"));
    }

    @Test
    void findByRegNumTest() {
        assertEquals("John Doe", new Clients(clients).findByRegNumber("1234").getName());
    }

    @Test
    void findByNameTest() {
        assertEquals("4321", new Clients(clients).findByName("Jack Doe").get(0).getRegNumber());
    }

    @Test
    void findByNameThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Clients(clients).findByName("Xxx");
        });
    }

}