package week15d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitcoinTest {

    @Test
    void calculateBestBuySellDaysTest() {
        List<Integer> dollars = List.of(500, 200, 300, 600, 400, 1000, 750);
        BestBuyDays bestBuyDays = new Bitcoin().calculateBestBuySellDays(dollars);
        assertEquals(2, bestBuyDays.getBuyDay());
        assertEquals(6, bestBuyDays.getSellDay());
    }
}