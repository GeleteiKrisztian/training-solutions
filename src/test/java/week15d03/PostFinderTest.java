package week15d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    private List<Post> posts = List.of(new Post("Cím1", LocalDate.now().minusDays(2), null, "Semmi1", "jackdoe"),
            new Post("Cím2", LocalDate.now().plusDays(2), null, "Semmi2", "janedoe"),
            new Post("Cím3", LocalDate.now().minusDays(2), LocalDate.now().plusDays(2), "Semmi3", "jackdoe"));

    @Test
    void findPostsTest() {
        assertEquals(2, new PostFinder(posts).findPosts("jackdoe").size());
    }
}