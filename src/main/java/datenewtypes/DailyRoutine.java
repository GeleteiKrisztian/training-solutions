package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DailyRoutine {

    private LocalTime startTime;

    public DailyRoutine(int hour, int min) {
        this.startTime = LocalTime.of(hour, min);
    }

    public DailyRoutine(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(time, formatter);
    }

    public void setFutureTime(int minutes) {
        startTime = startTime.plusMinutes(minutes);
    }

    public boolean isBeforeNoon() {
        return startTime.isBefore(LocalTime.NOON);
    }
}
