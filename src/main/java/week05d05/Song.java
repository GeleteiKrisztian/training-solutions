package week05d05;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        if (lengthInSeconds < 0) {
            throw new IllegalArgumentException("Length can't be less than 0");
        }
        isEmpty(name);
        isEmpty(artist);
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    private void isEmpty(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Argument is null or empty!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)",artist,name,lengthInSeconds);
    }
}
