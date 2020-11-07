package task;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {

    private String title;
    private String discription;
    private LocalDateTime startDateTime;
    private LocalTime duration;

    public Task(String title, String discription) {
        this.title = title;
        this.discription = discription;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscription() {
        return discription;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void start() {
        startDateTime = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Task task = new Task("Gyakorlat", "Vasárnap estig leadni");
        task.start();
        task.setDuration(LocalTime.of(12,00));
        System.out.println(task.getStartDateTime());
        System.out.println(task.getTitle() + " - " + task.getDiscription() + " " + task.getDuration() + "-ig.");
    }
}
