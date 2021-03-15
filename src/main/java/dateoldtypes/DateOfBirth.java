package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOfBirth {

    private Date date;

    public DateOfBirth(int year, int month, int day) {
        if (month < 0 || month > 11 && day < 0 || day > 30) {
            throw new IllegalArgumentException("");
        }
        Calendar calendar = new GregorianCalendar(year, month , day);
        date = calendar.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: ");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: ");
        }
        if (isNull(locale)) {
            throw new NullPointerException("Locale must not be null!");
        }
        DateFormat df = new SimpleDateFormat(pattern, locale);
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("");
        }
    }

    public DateOfBirth(String dateString, String pattern) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: ");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: ");
        }
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("");
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (isNull(locale)) {
            throw new NullPointerException("Locale must not be null!");
        }
        Calendar calendar = new GregorianCalendar(locale);
        calendar.setTime(date);
        return "";
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: ");
        }
    DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date).toString();
    }

    public boolean isWeekDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return false;
    }

    private boolean isNull(Locale locale) {
        if (locale == null) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(String s) {
        if (s.isBlank()) {
            return true;
        }
        return false;
    }

}
