package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {

    private Duration dur = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        dur = dur.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        dur = dur.plusDays(days).plusHours(hours).plusMinutes(minutes);
    }

    public void addWorkTime(String durationString) {
        nullOrEmptyStrCheck(durationString);
        Duration duration = durationFormatValidator(durationString);
        dur = dur.plus(duration);
    }

    public int calculateWorkHours() {
        return (int) dur.toHours();
    }

    public String toString() {
        return String.format("Days: %d, hours: %d, minutes: %d", dur.toDaysPart(), dur.toHoursPart(), dur.toMinutesPart());
    }

    public Duration getWorkDuration() {
        return dur;
    }

    private Duration durationFormatValidator(String s) {
        try {
            Duration dur = Duration.parse(s);
            return dur;
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + s);
        }
    }

    private void nullOrEmptyStrCheck(String s) {
        if(s == null || s.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
    }
}
