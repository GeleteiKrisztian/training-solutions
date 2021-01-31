package week11d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourierTest {

    @Test
    void process() {
        InputStream inputStream = Courier.class.getResourceAsStream("/rides.txt");
        Courier courier = new Courier();
        courier.process(inputStream);
        assertEquals(61, courier.getRides().size());
    }

    @Test
    void firstRide() {
        InputStream inputStream = Courier.class.getResourceAsStream("/rides.txt");
        Courier courier = new Courier();
        courier.process(inputStream);
        assertEquals(1, courier.firstRide().getDay());
        assertEquals(1, courier.firstRide().getDelivery());
        assertEquals(3, courier.firstRide().getDistance());
    }

    @Test
    void workDays() {
        InputStream inputStream = Courier.class.getResourceAsStream("/rides.txt");
        Courier courier = new Courier();
        courier.process(inputStream);
        assertTrue(courier.workDays()[0]);
        assertFalse(courier.workDays()[5]);
    }

    @Test
    void dailyDistance() {
        InputStream inputStream = Courier.class.getResourceAsStream("/rides.txt");
        Courier courier = new Courier();
        courier.process(inputStream);
        assertEquals(75, courier.dailyDistance()[6]);
    }
}