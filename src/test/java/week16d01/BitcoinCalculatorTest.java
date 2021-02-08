package week16d01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitcoinCalculatorTest {
    private List<Bitcoin> bitcoins = List.of(new Bitcoin(10, LocalDate.of(2010,1,1)),
            new Bitcoin(200, LocalDate.of(2012,6,1)),
            new Bitcoin(300, LocalDate.of(2015, 3, 15)),
            new Bitcoin(100, LocalDate.of(2013, 2, 1)));


    @Test
    void resultDaysTest() {
        assertEquals(1, new BitcoinCalculator(bitcoins).minMaxDays().getBestBuyDay());
        assertEquals(4, new BitcoinCalculator(bitcoins).minMaxDays().getBestSelDay());
    }

}