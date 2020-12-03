package objectclass;

public class Book {

    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String toString() {
        return author + ":" + title;
    }

    public boolean equals(Object o) {
        return this == o;
    }

}

