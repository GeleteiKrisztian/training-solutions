package statements;

public class Time {

    private int hour;
    private int minute;
    private int sec;

    public Time(int hour,int minute,int sec) {
        this.hour = hour;
        this.minute = minute;
        this.sec = sec;
    }

    public int getInMinutes() {
        return (hour * 60) + minute;
    }

    public int getInSeconds() {
       return (hour * 60 * 60) + (minute * 60) + sec;
    }

    public boolean earlierThan(Time time) {
        return this.getInSeconds() < time.getInSeconds();
    }

    public String toString() {
        return hour + ":" + minute + ":" + sec;
    }
}
