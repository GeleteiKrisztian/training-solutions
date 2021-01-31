package week10d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelTest {

    @Test
    void returnedBusStopTest() {
        assertEquals(0, new Travel().getStopWithMax(this.getClass().getResourceAsStream("/utasadat.txt")));
    }

}
