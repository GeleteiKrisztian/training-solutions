package week05d05;

import org.junit.jupiter.api.Test;
import week05d05.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SongTest {

    @Test
    void songConstructorTestNameIsNull() throws IllegalArgumentException {
            Exception ex = assertThrows(IllegalArgumentException.class, () -> new Song(null,30,"Valami"));
            assertEquals("Argument is null or empty!", ex.getMessage());
        }

        @Test
        void songConstructorTestArtistIsNull() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Song("Valami",30,null));
        assertEquals("Argument is null or empty!",ex.getMessage());
        }

        @Test
        void songConstructorTestLengthLessThanZero() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Song("Valami",-1,"Valaki"));
        assertEquals("Length can't be less than 0",ex.getMessage());
    }

    @Test
    void songToStringTest() {
        assertEquals("Valaki - Valami (180)",new Song("Valami",180,"Valaki").toString());
    }

}
