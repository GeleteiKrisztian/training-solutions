package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private List<String> composer;
    private int length;
    private List<String> performers;
    private String title;

    public AudioFeatures(String title, int length, List<String> performers) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (length < 1 || Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("");
        }
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("");
        }
        this.composer = composer;
    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (String item : performers) {
            contributors.add(item);
        }
        if (!Validators.isEmpty(composer)) {
            for (String item : composer) {
                contributors.add(item);
            }
        }
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

}
