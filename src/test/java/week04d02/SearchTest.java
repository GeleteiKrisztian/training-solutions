package week04d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void getIndexesOfCharExpRes() {
        Search search = new Search();
        List<Integer> indexes = search.getIndexesOfChar("almafa", 'a');
        assertEquals(3, indexes.size());
        assertEquals(5, indexes.get(2));
        }
}