package exam02.photo;

public class Photo implements Qualified {

    private String name;
    private Quality quality;

    public Photo(String name) {
        this(name,Quality.NO_STAR);
    }

    public Photo(String name, Quality quality) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name can't be null or empty.");
        }
        this.name = name;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    @Override
    public Quality getQuality() {
        return quality;
    }

    @Override
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

}
