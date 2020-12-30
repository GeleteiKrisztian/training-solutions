package week05d05;

import org.junit.jupiter.api.Test;
import week05d05.PlayList;
import week05d05.Song;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayListTest {
    PlayList playList = new PlayList(List.of(new Song("Young",180,"Chainsmokers"),new Song("One More Light",240,"Linkin Park")));

    @Test
    void findByLengthGreaterThanTest() {
        assertEquals(1,playList.findByLengthGreaterThan(3).size());
    }

}
