package defaultconstructor;

import java.time.Month;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        isCorrect(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private boolean isCorrect(int year, int month, int day) {
        if (year >= 1990 && (month > 0 && month < 13) && (day > 0 && day <= calculateMonthLength(year,Month.of(month)))) {
            return true;
        } else {
            throw new IllegalArgumentException(String.format("One or more given parameter cannot be applied! %d, %d, %d",year,month,day));
        }
    }

    private boolean isLeapYear(int year) {
        // if the year is divided by 4
        if (year % 4 == 0) {

            // if the year is century
            if (year % 100 == 0) {

                // if year is divided by 400
                // then it is a leap year
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }

            // if the year is not century
            else
                return true;
        }

        else
            return false;

    }

    private int calculateMonthLength(int year, Month month) {
       return month.length(isLeapYear(year));
    }

}
