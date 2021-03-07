package week15d03;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPosts(String user) {
        return posts.stream().filter(p -> p.getPublishedAt().isBefore(LocalDate.now())).filter(p -> p.getOwner().equals(user)).collect(Collectors.toList());
    }
}
