package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... names) {
        if (isNullOrEmptyArray(names)) {
            throw new IllegalArgumentException("Names can't be null or empty");
        }
        for (String item : names) {
            photos.add(new Photo(item));
        }
    }

    public void starPhoto(String name, Quality quality) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name can't be null.");
        }
        for (Photo item : photos) {
            if (item.getName().equals(name)) {
                item.setQuality(quality);
                return;
            }
            throw new PhotoNotFoundException("Photo not found.");
        }

    }

    public int numberOfStars() {
        int stars = 0;
        for (Photo item : photos) {
            stars += item.getQuality().ordinal();
        }
        return stars;
    }

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

    private boolean isNullOrEmptyArray(String[] sArr) {
        if (sArr == null || sArr.length == 0) {
            return true;
        }
        return false;
    }

}
