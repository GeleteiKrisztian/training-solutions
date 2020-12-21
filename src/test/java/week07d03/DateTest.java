package week07d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {

    @Test
    void createDate() {
        assertEquals("2020/1/30", Date.of(2020, 01, 30).toString());
    }

    @Test
    void getDateYear() {
        assertEquals(2020, Date.of(2020, 01, 30).getYEAR());
    }

    @Test
    void withMethodTest() {
        assertEquals(15, Date.of(2020, 01, 30).withDay(15).getDAY());
    }

}
