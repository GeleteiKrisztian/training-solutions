package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumResultsTest {
    SumResults sumResult = new SeparatedSum().sumString("-1;0;2,4;-1,1");

    @Test
    void negativeSum() {
        assertEquals(-2.1,sumResult.getNegSum());
    }

    @Test
    void positiveSum() {
        assertEquals(2.4,sumResult.getPosSum());
    }

    @Test
    void negativeNumsList() {
        assertEquals("[-1.0, -1.1]",sumResult.getNegativeNumbers().toString());
    }

    @Test
    void positiveNumsList() {
        assertEquals("[0.0, 2.4]",sumResult.getPositiveNumbers().toString());
    }

}
