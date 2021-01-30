package datenewtypes;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {

    private Duration workDuration = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        workDuration = workDuration.plus(duration);
    }

    public void addWorkTime(int hour, int min, int sec) {
        workDuration = workDuration.plus(Duration.parse("PT" + hour + "H" + min + "M" + sec + "S"));
    }

    public void addWorkTime(String durationString) {
        if (isNullOrEmpty(durationString)) {
            throw new IllegalArgumentException("");
        }
        try {
            workDuration = workDuration.plus(Duration.parse(durationString));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("", dtpe);
        }
    }

    public int calculateWorkHours() {
        return (int) workDuration.toHours();
    }

    public Duration getWorkDuration() {
        return workDuration;
    }

    public String toString() {
        return workDuration.toString();
    } //IDK :D

        public boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
        }

}
