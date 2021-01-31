package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    private int[] numsArr = new int[] {5, 1, 4, 5};
    private int[] numsArr2 = new int[] {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};

    @Test
    void onePairTest() {
        assertEquals(1, new PairFinder().findPairs(numsArr));
    }

    @Test
    void morePairTest() {
        assertEquals(4, new PairFinder().findPairs(numsArr2));
    }

}