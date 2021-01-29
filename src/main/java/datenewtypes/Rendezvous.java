package datenewtypes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class Rendezvous {

    private LocalTime time;

    public Rendezvous(String time, String pattern) {
        if (isNullOrEmpty(time)) {
            throw new IllegalArgumentException("Illegal time string: " + time);
        }
        if (isEmptyPattern(pattern)) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        try {
            this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Illegal time string: " + time);
        }
    }

    public Rendezvous(int hour, int min) {
        this.time = LocalTime.of(hour, min);
    }

    public String toString(String s) {
        if (isEmptyPattern(s)) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
        return time.format(DateTimeFormatter.ofPattern(s));
    }

    public long countMinutesLeft(LocalTime timePar) {
        if (time.isBefore(timePar)) {
            throw new MissedOpportunityException("Too late!");
        }
        return ChronoUnit.MINUTES.between(timePar, time);
    }

    public LocalTime pushLater(long hour,long min) {
        time = time.plusHours(hour).plusMinutes(min);
        return time;
    }

    public LocalTime pullEarlier(long hour, long min) {
        time = time.minusMinutes(min).minusHours(hour);
        return time;
    }

    private boolean isNullOrEmpty(String s) {
        if (s == null || s.isBlank()) {
            return true;
        }
        return false;
    }

    private boolean isEmptyPattern(String s) {
        if (s.isBlank()) {
            return true;
        }
        return false;
    }

}
