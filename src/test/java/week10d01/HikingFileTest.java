package week10d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikingFileTest {

    @Test
    void resultRaisingTest() {
        assertEquals(60, new HikingFile().getPlusElevation(this.getClass().getResourceAsStream("/GPSData.txt")).getRaisingSum());
    }

    @Test
    void resultDecraiseTest() {
        assertEquals(35, new HikingFile().getPlusElevation(this.getClass().getResourceAsStream("/GPSData.txt")).getDecreaseSum());
    }


}
