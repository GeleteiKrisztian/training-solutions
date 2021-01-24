package week04d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void getIndexesOfCharExpRes() {
        Search search = new Search();
        assertEquals(3, search.getIndexesOfChar("almafa", 'a').size());
        }
}