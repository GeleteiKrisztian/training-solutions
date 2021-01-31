package week08d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamplesStoreTest {

    @Test
    void titlesSizeTest() {
        assertEquals(2, new ExamplesStore().getTitlesOfExamples("/examples.md").size());
    }

    @Test
    void titlesfirstItem() {
        assertEquals("# Első feladat", new ExamplesStore().getTitlesOfExamples("/examples.md").get(0));
    }
}
