package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime localDateTime, Status status) {
        this.name = name;
        this.time = localDateTime;
        this.status = status;
    }

    public Issue(Issue another, CopyMode copyMode) {
        name = another.name;
        time = another.time;
        status = another.status;
        if (copyMode == CopyMode.WITH_COMMENTS) {
            List<Comment> commentsTemp = new ArrayList<>();
            for (Comment item : another.comments) {
                commentsTemp.add(new Comment(item));
            }
            comments = commentsTemp;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    //Nem fut le a teszteset,ha new ArrayList<>()-el térek vissza.
    public List<Comment> getComments() {
        return comments;
    }
}
