package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private LocalDate date;

    public DateOfBirth(String date, String format) {
        if (isFormatBlank(format)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    public DateOfBirth(String date, String format, Locale locale) {
        if (isLocaleNull(locale)) {
            throw new NullPointerException("Locale must not be null!");
        }
        if (isFormatBlank(format)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern(format, locale));
    }

    public DateOfBirth(int year, int month, int day) {
        date = LocalDate.of(year, month, day);
    }

    public LocalDate getDateOfBirth() {
        return date;
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate date) {
        if (isLocaleNull(locale)) {
            throw new IllegalArgumentException("Locale must not be null!");
        }
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (isLocaleNull(locale)) {
            throw new NullPointerException("Locale must not be null!");
        }
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    public long countDaysSinceBirth(LocalDate localDate) {
        if (date.isAfter(localDate)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
        return ChronoUnit.DAYS.between(date, localDate);
    }

    public long countDaysBetween(DateOfBirth dateOfBirth) {
        return ChronoUnit.DAYS.between(date, dateOfBirth.getDateOfBirth());
    }

    public String toString(String format) {
        if (isFormatBlank(format)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    private boolean isLocaleNull(Locale locale) {
        if(locale == null) {
            return true;
        }
        return false;
    }

    private boolean isFormatBlank(String format) {
        if (format.isBlank()) {
            return true;
        }
        return false;
    }
}
