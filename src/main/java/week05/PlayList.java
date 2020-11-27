package week05;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

    private List<Song> songs;

    public PlayList(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
    }

    public List<Song> findByLengthGreaterThan(int min) {
        List<Song> resSongs = new ArrayList<>();
        for (Song item : songs) {
            if ((double)min < (double)(item.getLengthInSeconds() / 60)) {
                resSongs.add(item);
            }
        }
        return resSongs;
    }

}
