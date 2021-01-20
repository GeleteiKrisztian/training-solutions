package week12d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeSorterTest {

    @Test
    void sortAgesLast() {
        int[] ages = {13,3,7,5,9,22,41,33};
        assertEquals(41, new AgeSorter().sortAges(ages)[ages.length - 1]);
    }

    @Test
    void sortAgesFirst() {
        int[] ages = {13,3,7,5,9,22,41,33};
        assertEquals(3, new AgeSorter().sortAges(ages)[0]);
    }
}