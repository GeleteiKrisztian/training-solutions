package week15d03;

import java.time.LocalDate;

public class Post {
    private String title;
    private LocalDate publishedAt;
    private LocalDate deletedAt;
    private String content;
    private String owner;

    public Post(String title, LocalDate publishedAt, LocalDate deletedAt, String content, String owner) {
        this.title = nullOrEmptyCheck(title);
        this.publishedAt = publishedAt;
        this.deletedAt = deletedAt;
        this.content = nullOrEmptyCheck(content);
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public LocalDate getDeletedAt() {
        return deletedAt;
    }

    public String getContent() {
        return content;
    }

    public String getOwner() {
        return owner;
    }

    private String nullOrEmptyCheck(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Null or empty string");
        }
        return s;
    }
}