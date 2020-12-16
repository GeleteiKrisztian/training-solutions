package week08d03;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListsTest {

    List<String> words = List.of("a", "b", "aa", "aaa", "bbb", "ccc");

    @Test
    void resultListSizeTest() {
        assertEquals(2,new StringLists().shortestWords(words).size());
    }

    @Test
    void resultFirstItem() {
        assertEquals("a",new StringLists().shortestWords(words).get(0));
    }

}
