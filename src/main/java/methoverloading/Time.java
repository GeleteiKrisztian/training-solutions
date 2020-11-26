package methoverloading;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public Time(Time time) {
        hours = time.getHours();
        minutes = time.getMinutes();
        seconds = time.getSeconds();
    }

    public int timeToSec(Time time) {
        return (time.getHours() * 60 * 60) + (time.getMinutes() * 60) + (time.getSeconds() * 60);
    }

    public boolean isEqual(Time time) {
        if (timeToSec(this) == timeToSec(time)) {
            return true;
        }
        return false;
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        if (timeToSec(this) == timeToSec(new Time(hours, minutes, seconds))) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(Time time) {
        if (timeToSec(this) < timeToSec(time)) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        if (timeToSec(this) < timeToSec(new Time(hours, minutes, seconds))) {
            return true;
        }
        return false;
    }

}
