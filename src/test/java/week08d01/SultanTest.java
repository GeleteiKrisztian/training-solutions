package week08d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SultanTest {

    Sultan sultan = new Sultan();
    List<Boolean> doors = sultan.openDoors();

    @Test
    void firstOfHundred() {
        assertTrue(doors.get(0));
    }
}
