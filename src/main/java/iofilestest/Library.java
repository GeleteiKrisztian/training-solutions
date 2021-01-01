package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void add(Book... books) {
        for (Book item : books) {
            if(!isContains(item)) {
                this.books.add(item);
            }
        }
    }

    public void saveBooks(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Book item : books)
            bw.write(item.getAuthor() + ":" + item.getTitle() + "\n");
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't write the file.", ioe);
        }
    }

    public void loadBooks(Path path) {
        books = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(":");
                Book book = new Book(split[0], split[1]);
                add(book);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read the file.", ioe);
        }
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    private boolean isContains(Book book) {
        for (Book item : books) {
            if (item.getTitle().equals(book.getTitle()) && item.getAuthor().equals(book.getAuthor())) {
                return true;
            }
        }
        return false;
    }

}
