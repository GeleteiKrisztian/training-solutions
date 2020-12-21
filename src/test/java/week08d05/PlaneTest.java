package week08d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaneTest {

    @Test
    void oceanLengthTest() {
        assertEquals(16,new Plane().calculateLongestOceanPart(Path.of("map.txt")));
    }

    @Test
    void exceptionWhenBadPathTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Plane().calculateLongestOceanPart(Path.of("mapx.txt")));
        assertEquals("Can't read the file.", ex.getMessage());
    }

}
