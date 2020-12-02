package week06d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeriesTest {
    List<Integer> numbersAsc = List.of(1,3,4,5,7,9);
    List<Integer> numbersDesc = List.of(9,7,5,4,3,1);
    List<Integer> numbersRand = List.of(1,3,5,7,4,9);
    List<Integer> numbersLessThanRequired = List.of(1);

    @Test
    void isAsc() {
        assertEquals(ListType.ASCENDING,new Series().calculateSeriesType(numbersAsc));
    }

    @Test
    void isDesc() {
        assertEquals(ListType.DESCENDING,new Series().calculateSeriesType(numbersDesc));
    }

    @Test
    void isRand() {
        assertEquals(ListType.RANDOM,new Series().calculateSeriesType(numbersRand));
    }

    @Test
    void argThrowsException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Series().calculateSeriesType(null);
        });

        assertEquals("List can't be null or size less than 2!", ex.getMessage());
    }

    @Test
    void argThrowsExceptionWithList() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Series().calculateSeriesType(null);
        });

        assertEquals("List can't be null or size less than 2!", ex.getMessage());
    }

}
